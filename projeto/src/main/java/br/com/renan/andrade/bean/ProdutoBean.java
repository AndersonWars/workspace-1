package br.com.renan.andrade.bean;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.faces.event.*;
import javax.imageio.*;

import org.omnifaces.util.*;
import org.primefaces.event.*;
import org.primefaces.model.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{
	
	private Produto produto;
	private List<Produto> produtos;
	
	@PostConstruct
	public void novo() {
		produto = new Produto();
		listar();
		File f = new File("C:/Users/Renan/workspace/workspace/uploads/temp.png");
		if (f.isFile()) {
			f.delete();
		}
	}
	
	public void salvar() {
		try {
			ProdutoDao dao = new ProdutoDao();
			Produto produtoN =  dao.merge(produto);
			
			Path origem = Paths.get(produto.getCaminhoUpload());
			Path destino = Paths.get("C:/Users/Renan/workspace/workspace/uploads/"+produtoN.getCodProduto()+".png");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
			
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
		Path caminho = Paths.get("C:/Users/Renan/workspace/workspace/uploads/"+produto.getCodProduto()+".png");
		Files.deleteIfExists(caminho);
		listar();
		novo();
		Messages.addGlobalInfo(produto.getNmProduto()+" - Excluido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(ActionEvent event) {
		produto = (Produto)event.getComponent().getAttributes().get("prodAlterar");
		produto.setCaminhoUpload("C:/Users/Renan/workspace/workspace/uploads/"+produto.getCodProduto()+".png");
	}
	
	public void listar() {
		try {
			ProdutoDao dao = new ProdutoDao();
			produtos = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upload(FileUploadEvent evento) {
		try {
			UploadedFile x = evento.getFile();
			Path t = Files.createTempFile(null, null);
			Files.copy(x.getInputstream(), t, StandardCopyOption.REPLACE_EXISTING);
			produto.setCaminhoUpload(t.toString());
			Path origem = Paths.get(produto.getCaminhoUpload());
			Path destino = Paths.get("C:/Users/Renan/workspace/workspace/uploads/temp.png");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
		}catch (Exception e) {
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
