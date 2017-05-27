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
public class LoginBean implements Serializable {
	
	private Usuario usuario;
	
	@PostConstruct
	private void instac() {
		usuario = new Usuario();
	}
	
	public String fazLogin() {
		try {
			usuario = new UsuarioDao().procuraUsuario(usuario);
			if (usuario == null) {
				throw new NumberFormatException();
			} else {
				Cliente cliente = new ClienteDao().buscaPorUsuario(usuario.getCdUsuario());
			}
			return "vendaGrid?faces-redirect=true";
		} catch (NumberFormatException e) {
			Messages.addGlobalWarn("Usuário não encontrado");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao efetuar login");
			e.printStackTrace();
		} finally {
			if (usuario == null) {
				usuario = new Usuario();
			}
		}
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
