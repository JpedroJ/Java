package despesas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Despesas")
public class DespesaModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo", unique=true, nullable=false)
	private int codigo;
	@Column(name="categoria", nullable=false, length=40)
	private String categoria;
	@Column(name="descricao", nullable=false, length=100)
	private String descricao;
	@Column(name="valor", nullable=false)
	private double valor;
	@Column(name="data_pagamento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
