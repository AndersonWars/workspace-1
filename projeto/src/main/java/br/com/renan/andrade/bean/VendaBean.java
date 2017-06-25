package br.com.renan.andrade.bean;

import java.io.*;
import java.time.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;

import org.omnifaces.util.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	
	private Venda venda;
	private Usuario usuario;
	private Cliente cliente;
	private List<Produto> listProd;
	private List<ItemVenda> itensVenda;
	private Produto produtoSelecionado;
	private Integer qtdItens;
	private ItemVenda itemSelecionado;
	
	@PostConstruct
	public void list() {
		listProd = new ProdutoDao().listarTodos();
		usuario = new Usuario();
		itensVenda = new ArrayList<ItemVenda>();
		venda = new Venda();
		venda.setCodCliente(SessionContext.getInstance().getClienteSessao());
	}
	
	public void salvaVenda() {
		try {
			VendaDao dao = new VendaDao();
			venda.setDatVenda(Date.from(Instant.now()));
			venda.setCodCliente(SessionContext.getInstance().getClienteSessao());
			venda = dao.merge(getVenda());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void salvarItem(ItemVenda item) {
		try {
			ItemVendaDao dao = new ItemVendaDao();
			dao.merge(item);
			afterSalvarItem(item, true);
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao inserir novo item");
			itensVenda.remove(itensVenda.size()-1);
			e.printStackTrace();
		} finally {
			qtdItens = 0;
		}
	}
	
	public void insereItemVenda() {
		salvaVenda();
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setCodProduto(produtoSelecionado);
		itemVenda.setQtdItem(getQtdItens());
		itemVenda.setCodVenda(venda);
		itemVenda.setVlrItem(itemVenda.getQtdItem()*produtoSelecionado.getVlrProduto());
		itemVenda.setSeqItem(itensVenda.size()+1);
		itensVenda.add(itemVenda);
		salvarItem(itemVenda);
	}
	
	private void afterSalvarItem(ItemVenda item, boolean sucesso) {
		if (sucesso) {
			Produto produto = item.getCodProduto();
			produto.setQtdProduto(produto.getQtdProduto() - item.getQtdItem());
			try {
				new ProdutoDao().merge(produto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void excluiItem(ItemVenda item) {
		try {
			new ItemVendaDao().excluir(item);
			itensVenda.remove(item);
			Messages.addGlobalInfo("Item excluído");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao excluir item");
			e.printStackTrace();
		} 
	}
	
	public void finalizarCompra() {
		ClienteDao dao = new ClienteDao();
		VendaDao vDao = new VendaDao();
		if (venda.getCodCliente() != null && dao.clienteExiste(venda.getCodCliente().getCodCliente())) {
			if (itensVenda.size() > 0) {
				try {
					Double valorFinal = 0.0;
					for (ItemVenda i : itensVenda) {
						valorFinal += i.getVlrItem();
					}
					venda.setVlrVenda(valorFinal);
					vDao.merge(venda);
					Messages.addGlobalInfo("Venda completada");
				} catch (Exception e) {
					e.printStackTrace();
					Messages.addGlobalError("Erro ao finalizar venda");
					vDao.excluir(venda);
				}
			} else {
				Messages.addGlobalError("Essa venda não possui itens");
			}
		} else {
			Messages.addGlobalError("Cliente da venda é inválido");
		}
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Produto> getListProd() {
		return listProd;
	}

	public void setListProd(List<Produto> listProd) {
		this.listProd = listProd;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemVenda getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(ItemVenda itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
	
}
