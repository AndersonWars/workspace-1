package br.com.renan.andrade.bean;

import java.io.*;

import javax.faces.bean.*;

import br.com.renan.andrade.util.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HomeBean implements Serializable {
	
	public boolean isUserLogado() {
		return SessionContext.getInstance().getUsuarioLogado() != null;
	}
	
	public String logout() {
		SessionContext.getInstance().encerrarSessao();
		return "/templates/home?faces-redirect=true";
	}
	
	public String getUserName() {
		return "Bem vindo " +SessionContext.getInstance().getUsuarioLogado().getDsLogin();
	}

}
