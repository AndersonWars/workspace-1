package br.com.renan.andrade.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class ItensVenda implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long seq_item;
	
	@Id
	@ManyToOne
	@JoinColumn
	private Venda cod_venda;
	
	@OneToMany
	@JoinColumn
	private Produto cod_produto;
	
	@Column
	private Double vlr_item;
	
	@Column
	private Integer qtd_item;

	public Long getSeq_item() {
		return seq_item;
	}

	public void setSeq_item(Long seq_item) {
		this.seq_item = seq_item;
	}

	public Venda getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(Venda cod_venda) {
		this.cod_venda = cod_venda;
	}

	public Produto getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Produto cod_produto) {
		this.cod_produto = cod_produto;
	}

	public Double getVlr_item() {
		return vlr_item;
	}

	public void setVlr_item(Double vlr_item) {
		this.vlr_item = vlr_item;
	}

	public Integer getQtd_item() {
		return qtd_item;
	}

	public void setQtd_item(Integer qtd_item) {
		this.qtd_item = qtd_item;
	}
	
	

}
