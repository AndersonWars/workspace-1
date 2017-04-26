package br.com.renan.andrade.bean;

import java.io.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;
import javax.faces.event.*;

import org.omnifaces.util.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{
	
	public Produto produto;
	public List<Produto> produtos;
	
	@PostConstruct
	public void novo() {
		produto = new Produto();
		listar();
	}
	
	public void salvar() {
		try {
			ProdutoDao dao = new ProdutoDao();
			dao.merge(produto);
			Messages.addGlobalInfo("Produto " + produto.getNmProduto() + " foi cadastrado");
			listar();
			novo();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar");
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent event) {
		try {
		produto = (Produto)event.getComponent().getAttributes().get("prodExcluir");
		ProdutoDao dao = new ProdutoDao();
		dao.excluir(produto);
		listar();
		Messages.addGlobalInfo(produto.getNmProduto()+" - Excluido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(ActionEvent event) {
		produto = (Produto)event.getComponent().getAttributes().get("prodAlterar");
	}
	
	public void listar() {
		try {
			ProdutoDao dao = new ProdutoDao();
			produtos = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
