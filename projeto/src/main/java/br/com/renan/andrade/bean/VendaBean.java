package br.com.renan.andrade.bean;

import java.io.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;

import org.omnifaces.util.*;
import org.primefaces.context.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	
	private Venda venda;
	private Usuario usuario;
	private List<Produto> listProd;
	private List<ItemVenda> itensVenda;
	private Produto produtoSelecionado;
	private Integer qtdItens;
	
	@PostConstruct
	public void list() {
		listProd = new ProdutoDao().listarTodos();
		usuario = new Usuario();
		itensVenda = new ArrayList<ItemVenda>();
		RequestContext.getCurrentInstance().execute("PF('loginDialog').show()");
		venda = new Venda();
	}
	
	public void fazLogin() {
		try {
			usuario = new UsuarioDao().procuraUsuario(usuario);
			if (usuario == null)
				throw new NumberFormatException();
			else
				RequestContext.getCurrentInstance().execute("PF('loginDialog').hide()");
		} catch (NumberFormatException e) {
			Messages.addGlobalWarn("Usuário não encontrado");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao efetuar login");
			e.printStackTrace();
		} finally {
			if (usuario == null)
				usuario = new Usuario();
		}
	}
	
	private void salvarItem(ItemVenda item) {
		try {
			ItemVendaDao dao = new ItemVendaDao();
			dao.merge(item);
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao inserir novo item");
			e.printStackTrace();
		}
	}
	
	public void insereItemVenda() {
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setCodProduto(produtoSelecionado);
		itemVenda.setQtdItem(getQtdItens());
		itemVenda.setSeqItem(Long.valueOf(itensVenda.size() + 1));
		itensVenda.add(itemVenda);
		salvarItem(itemVenda);
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
	
}
