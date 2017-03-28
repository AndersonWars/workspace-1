package br.com.renan.andrade.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Produto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cod_produto;
	
	@Column(length=100)
	private String des_produto;
	
	@Column
	private Double vlr_produto;
	
	@Column
	private Integer qtd_produto;

	public Long getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Long cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getDes_produto() {
		return des_produto;
	}

	public void setDes_produto(String des_produto) {
		this.des_produto = des_produto;
	}

	public Double getVlr_produto() {
		return vlr_produto;
	}

	public void setVlr_produto(Double vlr_produto) {
		this.vlr_produto = vlr_produto;
	}

	public Integer getQtd_produto() {
		return qtd_produto;
	}

	public void setQtd_produto(Integer qtd_produto) {
		this.qtd_produto = qtd_produto;
	}
	
	

}
