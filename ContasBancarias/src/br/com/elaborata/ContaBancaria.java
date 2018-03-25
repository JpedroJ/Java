package br.com.elaborata;
import java.util.Date;

public class ContaBancaria {

	private String banco;
	private String agencia;
	private Integer numero;
	private Double saldo;
	private Date dataAbertura;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public ContaBancaria() {
		super();
		this.saldo = 300.00;
		this.dataAbertura = new Date();
	}
	public ContaBancaria(Double saldo) {
		super();
		this.saldo = saldo;
		this.dataAbertura = new Date();
	}

	public void depositar(Double valor) {
		this.saldo += valor;
	}

	public boolean sacar(Double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}
}
