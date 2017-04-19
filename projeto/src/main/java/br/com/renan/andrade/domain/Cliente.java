package br.com.renan.andrade.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cod_cliente;
	
	@Column(length=100)
	private String nom_cliente;
	
	@Column(length=100)
	private String end_cliente;
	
	@Column(length=100)
	private String cid_cliente;
	
	@Column(length=10)
	private String cep_cliente;
	
	/*
	@Column(length=13)
	private String cpf_cliente;
	
	@Column(length=11)
	private String tel_cliente;
	
	@Column(length=100)
	private String email_cliente;
	*/

	public Long getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(Long cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getEnd_cliente() {
		return end_cliente;
	}

	public void setEnd_cliente(String end_cliente) {
		this.end_cliente = end_cliente;
	}

	public String getCid_cliente() {
		return cid_cliente;
	}

	public void setCid_cliente(String cid_cliente) {
		this.cid_cliente = cid_cliente;
	}

	public String getCep_cliente() {
		return cep_cliente;
	}

	public void setCep_cliente(String cep_cliente) {
		this.cep_cliente = cep_cliente;
	}
	
	/*
	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	*/
	

}
