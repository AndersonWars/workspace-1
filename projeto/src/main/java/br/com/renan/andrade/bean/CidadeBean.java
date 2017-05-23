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
public class CidadeBean implements Serializable{
	
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;
	
	public void novo() {
		cidade = new Cidade();
		carregaUfs();
	}
	
	public void excluir(ActionEvent event) {
		try {
		cidade = (Cidade)event.getComponent().getAttributes().get("cidadeExcluir");
		CidadeDao dao = new CidadeDao();
		dao.excluir(cidade);
		listar();
		Messages.addGlobalInfo(cidade.getNome()+" - Excluida com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void carregaUfs() {
		try {
			EstadoDao dao = new EstadoDao();
			estados = dao.listarTodos();
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar estados");
			e.printStackTrace();
		}
	}
	
	public void alterar(ActionEvent event) {
		cidade = (Cidade)event.getComponent().getAttributes().get("cidadeAlterar");
		carregaUfs();
	}
	
	@PostConstruct
	public void listar() {
		try {
			CidadeDao dao = new CidadeDao();
			cidades = dao.listarTodos();
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao listar cidades");
			e.printStackTrace();
		}
	}
	
	public void salvar() {
		try{
			CidadeDao dao = new CidadeDao();
			dao.merge(cidade);
			Messages.addGlobalInfo("Cidade cadastrada com sucesso");
			novo();
			listar();
		}catch(Exception e) {
			Messages.addGlobalError("Erro ao cadastrar cidade");
			e.printStackTrace();
		}
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	//test
	
}
