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
public class ItemVenda implements Serializable{
	
	@Id
	private Long seqItem;
	
	@Id
	@ManyToOne
	@JoinColumn
	private Venda codVenda;
	
	
	@JoinColumn
	@ManyToOne
	private Produto codProduto;
	
	@Column
	private Double vlrItem;
	
	@Column
	private Integer qtdItem;

	public Long getSeqItem() {
		return seqItem;
	}

	public void setSeqItem(Long seqItem) {
		this.seqItem = seqItem;
	}

	public Venda getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(Venda codVenda) {
		this.codVenda = codVenda;
	}

	public Produto getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Produto codProduto) {
		this.codProduto = codProduto;
	}

	public Double getVlrItem() {
		return vlrItem;
	}

	public void setVlrItem(Double vlrItem) {
		this.vlrItem = vlrItem;
	}

	public Integer getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(Integer qtdItem) {
		this.qtdItem = qtdItem;
	}
	
	

}
