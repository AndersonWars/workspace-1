package br.com.renan.andrade.domain;

import java.io.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cod_endereco;
	
	@Column(length=100)
	private String rua_endereco;
	
	@Column(length=100)
	private String cidade_endereco;
	
	@JoinColumn
	@ManyToOne
	private Estado cod_uf;
	
	@Column(length=10)
	private String cep_endereco;
	
	@Column(length=10)
	private Integer nu_logradouro;
	
	@Column(length=100)
	private String bairro_endereco;

	public Long getCod_endereco() {
		return cod_endereco;
	}

	public void setCod_endereco(Long cod_endereco) {
		this.cod_endereco = cod_endereco;
	}

	public String getRua_endereco() {
		return rua_endereco;
	}

	public void setRua_endereco(String rua_endereco) {
		this.rua_endereco = rua_endereco;
	}

	public String getCidade_endereco() {
		return cidade_endereco;
	}

	public void setCidade_endereco(String cidade_endereco) {
		this.cidade_endereco = cidade_endereco;
	}

	public Estado getCod_uf() {
		return cod_uf;
	}

	public void setCod_uf(Estado cod_uf) {
		this.cod_uf = cod_uf;
	}

	public String getCep_endereco() {
		return cep_endereco;
	}

	public void setCep_endereco(String cep_endereco) {
		this.cep_endereco = cep_endereco;
	}

	public Integer getNu_logradouro() {
		return nu_logradouro;
	}

	public void setNu_logradouro(Integer nu_logradouro) {
		this.nu_logradouro = nu_logradouro;
	}

	public String getBairro_endereco() {
		return bairro_endereco;
	}

	public void setBairro_endereco(String bairro_endereco) {
		this.bairro_endereco = bairro_endereco;
	}
	
	
}
