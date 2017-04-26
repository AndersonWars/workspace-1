package br.com.renan.andrade.bean;

import java.io.*;

import javax.annotation.*;
import javax.faces.bean.*;

import org.omnifaces.util.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	
	private Usuario usuario;
	private String confSenha;
	
	@PostConstruct
	public void novo(){
		usuario = new Usuario();
		confSenha = "";
	}
	
	public void salvar(){
		try{
			UsuarioDao dao = new UsuarioDao();
			if (validateSenha()) {
				dao.merge(usuario);
				Messages.addGlobalInfo("Usuário cadastrado");
				novo();
			}
		}catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar usuário");
			e.printStackTrace();
		}
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
	
	private Boolean validateSenha() {
		if (!usuario.getDsSenha().equals(confSenha)) {
			Messages.addGlobalError("Senha não confere. Tente novamente");
			return false;
		}
		return true;
	}
	

}
