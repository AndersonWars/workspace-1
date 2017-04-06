package br.com.renan.andrade.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable{
	
	private Estado estado;
	
	public void novo() {
		estado = new Estado();
	}
	
	public void salvar() {
//		FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvar", null);
//		FacesContext contexto = FacesContext.getCurrentInstance();
//		FacesContext.getCurrentInstance().addMessage(null, fMsg);
		try{
			EstadoDao dao = new EstadoDao();
			dao.Salvar(estado);
			Messages.addGlobalInfo("UF cadastrada com sucesso");
			novo();
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
	
	

}
