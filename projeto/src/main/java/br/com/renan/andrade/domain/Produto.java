package br.com.renan.andrade.domain;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Produto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codProduto;
	
	@Column(length=10)
	private String nmProduto;
	
	@Column(length=1000)
	private String desProduto;
	
	@Column
	private Double vlrProduto;
	
	@Column
	private Integer qtdProduto;
	
	@Transient
	private String caminhoUpload;

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getDesProduto() {
		return desProduto;
	}

	public void setDesProduto(String desProduto) {
		this.desProduto = desProduto;
	}

	public Double getVlrProduto() {
		return vlrProduto;
	}

	public void setVlrProduto(Double vlrProduto) {
		this.vlrProduto = vlrProduto;
	}

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getCaminhoUpload() {
		return caminhoUpload;
	}

	public void setCaminhoUpload(String caminhoUpload) {
		this.caminhoUpload = caminhoUpload;
	}
	
}
