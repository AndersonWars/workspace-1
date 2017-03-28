package br.com.renan.andrade.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Venda implements Serializable{
	
	@Id
	private Long cod_venda;
	
	@OneToMany
	@JoinColumn
	private Cliente cod_cliente;
	
	@Column
	private Date dat_venda;
	
	@Column
	private Double vlr_venda;

	public Long getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(Long cod_venda) {
		this.cod_venda = cod_venda;
	}

	public Cliente getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(Cliente cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public Date getDat_venda() {
		return dat_venda;
	}

	public void setDat_venda(Date dat_venda) {
		this.dat_venda = dat_venda;
	}

	public Double getVlr_venda() {
		return vlr_venda;
	}

	public void setVlr_venda(Double vlr_venda) {
		this.vlr_venda = vlr_venda;
	}
	
	
}
