package br.com.renan.andrade.bean;

import java.io.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	
	private Venda venda;
	private List<Produto> listProd;
	private List<ItemVenda> itensVenda;
	private Produto produtoSelecionado;
	private Integer qtdItens;
	
	@PostConstruct
	public void list() {
		listProd = new ProdutoDao().listarTodos();
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

	public void insereItemVenda() {
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setCodProduto(produtoSelecionado);
		
	}

}
