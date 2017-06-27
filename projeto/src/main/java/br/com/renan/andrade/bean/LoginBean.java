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
public class LoginBean implements Serializable {
	
	private Usuario usuario;
	private String dsLogin, dsSenha;
	
	@PostConstruct
	private void instac() {
		usuario = new Usuario();
	}
	
	public String fazLogin() {
		try {
			usuario = new UsuarioDao().procuraUsuario(dsLogin, CryptoUtil.generateCryptedPassword(dsSenha));
			if (usuario != null) {
				SessionContext.getInstance().setUsuarioLogado(usuario);
				Cliente cliente = new ClienteDao().buscaPorUsuario(usuario.getCdUsuario());
				if (cliente != null) {
					SessionContext.getInstance().setClienteSessao(cliente);
					return "/pages/listVenda?faces-redirect=true";
				} else {
					return "/templates/home.xhtml?faces-redirect=true";
				}
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			Messages.addGlobalWarn("Usuário não encontrado");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao efetuar login");
			e.printStackTrace();
		}
		return "";
	}
	
	public void resetData() {
		setDsLogin("");
		setDsSenha("");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDsLogin() {
		return dsLogin;
	}

	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	
}
