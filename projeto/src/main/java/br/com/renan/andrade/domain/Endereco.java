package br.com.renan.andrade.domain;

import java.io.*;
import java.util.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cdEndereco;
	
	@Column(length=100)
	private String ruaEndereco;
	
	@Column(length=100)
	private String cidEndereco;
	
	@JoinColumn
	@ManyToOne(cascade=CascadeType.ALL)
	private Estado cdUf;
	
	@Column(length=10)
	private String cepEndereco;
	
	@Column(length=10)
	private Integer nuLogradouro;
	
	@Column(length=100)
	private String bairroEndereco;

	public Long getCdEndereco() {
		return cdEndereco;
	}

	public void setCdEndereco(Long cdEndereco) {
		this.cdEndereco = cdEndereco;
	}

	public String getRuaEndereco() {
		return ruaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}

	public String getCidEndereco() {
		return cidEndereco;
	}

	public void setCidEndereco(String cidEndereco) {
		this.cidEndereco = cidEndereco;
	}

	public Estado getCdUf() {
		return cdUf;
	}

	public void setCdUf(Estado cdUf) {
		this.cdUf = cdUf;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public Integer getNuLogradouro() {
		return nuLogradouro;
	}

	public void setNuLogradouro(Integer nuLogradouro) {
		this.nuLogradouro = nuLogradouro;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}
	
	@Override
	public String toString() {
		return "Endereco[cdEndereco" + getCdEndereco() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEndereco == null) ? 0 : cdEndereco.hashCode());
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
		if (cdEndereco == null) {
			if (other.cdEndereco != null)
				return false;
		} else if (!cdEndereco.equals(other.cdEndereco))
			return false;
		return true;
	}
	
}
