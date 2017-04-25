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
	@ManyToOne(cascade=CascadeType.ALL)
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
	
	@Override
	public String toString() {
		return "Endereco[cod_Endereco" + getCod_endereco() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_endereco == null) ? 0 : cod_endereco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cod_endereco == null) {
			if (other.cod_endereco != null)
				return false;
		} else if (!cod_endereco.equals(other.cod_endereco))
			return false;
		return true;
	}
	
}
