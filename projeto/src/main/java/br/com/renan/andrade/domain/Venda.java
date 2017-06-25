package br.com.renan.andrade.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Venda implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codVenda;
	
	
	@JoinColumn
	@ManyToOne(cascade=CascadeType.ALL)
	private Cliente codCliente;
	
	@Column
	private Date datVenda;
	
	@Column
	private Double vlrVenda;

	public Long getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(Long codVenda) {
		this.codVenda = codVenda;
	}

	public Cliente getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Cliente codCliente) {
		this.codCliente = codCliente;
	}

	public Date getDatVenda() {
		return datVenda;
	}

	public void setDatVenda(Date datVenda) {
		this.datVenda = datVenda;
	}

	public Double getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(Double vlrVenda) {
		this.vlrVenda = vlrVenda;
	}
}