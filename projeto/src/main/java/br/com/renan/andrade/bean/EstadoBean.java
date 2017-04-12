package br.com.renan.andrade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable{
	
	private Estado estado;
	private List<Estado> estados;
	
	public void excluir(ActionEvent event) {
		try {
		estado = (Estado)event.getComponent().getAttributes().get("ufExcluir");
		EstadoDao dao = new EstadoDao();
		dao.excluir(estado);
		listar();
		Messages.addGlobalInfo(estado.getNome()+" - Excluido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(ActionEvent event) {
		estado = (Estado)event.getComponent().getAttributes().get("ufAlterar");
	}
	
	@PostConstruct
	public void listar() {
		try {
			EstadoDao dao = new EstadoDao();
			estados = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void novo() {
		estado = new Estado();
	}
	
	public void salvar() {
//		FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvar", null);
//		FacesContext contexto = FacesContext.getCurrentInstance();
//		FacesContext.getCurrentInstance().addMessage(null, fMsg);
		try{
			EstadoDao dao = new EstadoDao();
			dao.merge(estado);
			Messages.addGlobalInfo("UF cadastrada com sucesso");
			novo();
			listar();
		}catch(Exception e) {
			Messages.addGlobalError("Erro ao cadastrar estado");
			e.printStackTrace();
		}
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	

}
