package br.com.elaborata.veiculo;

public class Veiculo {

	private String placa;
	private String marca;
	private String modelo;
	private String ano;
	private String kmrodado;
	private String kminicial;
	private String kmfinal;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getKmrodado() {
		return kmrodado;
	}

	public void setKmrodado(String kmrodado) {
		this.kmrodado = kmrodado;
	}

	public String getKminicial() {
		return kminicial;
	}

	public void setKminicial(String kminicial) {
		this.kminicial = kminicial;
	}

	public Veiculo(String placa, String marca, String modelo, String ano, String kmrodado, String kminicial,
			String kmfinal) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.kmrodado = kmrodado;
		this.kminicial = kminicial;
		this.kmfinal = kmfinal;
	}

	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getKmfinal() {
		return kmfinal;
	}

	public void setKmfinal(String kmfinal) {
		this.kmfinal = kmfinal;
	}

}
