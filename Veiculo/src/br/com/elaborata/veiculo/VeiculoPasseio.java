package br.com.elaborata.veiculo;

public class VeiculoPasseio extends Veiculo {
	public String arcondicionado;
	public String numerodeportas;
	
	public String getArcondicionado() {
		return arcondicionado;
	}
	public void setArcondicionado(String arcondicionado) {
		this.arcondicionado = arcondicionado;
	}
	
	public String getNumerodeportas() {
		return numerodeportas;
	}
	public void setNumerodeportas(String numerodeportas) {
		this.numerodeportas = numerodeportas;
	}
	public VeiculoPasseio(String arcondicionado, String numerodeportas) {
		super();
		this.arcondicionado = arcondicionado;
		this.numerodeportas = numerodeportas;
	}
	public VeiculoPasseio() {
		super();
		// TODO Auto-generated constructor stub
	}
}
