package br.com.renan.andrade.domain;

import java.io.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cdUsuario;
	
	@Column(length=1)
	private Character tpUsuario;
	
	@Column(length=100)
	private String dsLogin;
	
	@Lob
	@Column
	private byte[] dsSenha;
	
	@Column
	private Boolean alteraCli;
	
	@Column
	private Boolean prodAlterar;
	
	@Column
	private Boolean comprar;

	public Long getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(Long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public Character getTpUsuario() {
		return tpUsuario;
	}

	public void setTpUsuario(Character tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

	public String getDsLogin() {
		return dsLogin;
	}

	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}

	public byte[] getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(byte[] dsSenha) {
		this.dsSenha = dsSenha;
	}

	public Boolean getAlteraCli() {
		return alteraCli;
	}

	public void setAlteraCli(Boolean alteraCli) {
		this.alteraCli = alteraCli;
	}

	public Boolean getProdAlterar() {
		return prodAlterar;
	}

	public void setProdAlterar(Boolean prodAlterar) {
		this.prodAlterar = prodAlterar;
	}

	public Boolean getComprar() {
		return comprar;
	}

	public void setComprar(Boolean comprar) {
		this.comprar = comprar;
	}
	
	
}
