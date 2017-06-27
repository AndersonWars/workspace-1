package br.com.renan.andrade.bean;

import java.io.*;

import javax.annotation.*;
import javax.faces.bean.*;

import org.omnifaces.util.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	
	private Usuario usuario;
	private String confSenha,dsSenha;
	
	@PostConstruct
	public void novo(){
		usuario = new Usuario();
		usuario.setTpUsuario('F');
		confSenha = "";
	}
	
	public String salvar(){
		try{
			UsuarioDao dao = new UsuarioDao();
			if (validateSenha()) {
				usuario.setDsSenha(CryptoUtil.generateCryptedPassword(getDsSenha()));
				dao.merge(usuario);
				Messages.addGlobalInfo("Usuário cadastrado");
				novo();
			}
		}catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar usuário");
			e.printStackTrace();
		}
		return "/templates/home.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}
	
	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	private Boolean validateSenha() {
		if (!getDsSenha().equals(confSenha)) {
			Messages.addGlobalError("Senha não confere. Tente novamente");
			return false;
		}
		return true;
	}
	

}
