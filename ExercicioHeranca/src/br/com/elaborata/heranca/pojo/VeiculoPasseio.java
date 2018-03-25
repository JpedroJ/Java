/**
 * 
 */
package br.com.elaborata.heranca.pojo;

/**
 * @author Roque Junior
 *
 */
public class VeiculoPasseio extends Veiculo {

	private Boolean arCondicionado;
	private Integer numeroPortas;

	public VeiculoPasseio() {
	}

	public VeiculoPasseio(Boolean arCondicionado, Integer numeroPortas) {
		this.arCondicionado = arCondicionado;
		this.numeroPortas = numeroPortas;
	}

	public Boolean getArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(Boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public Integer getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(Integer numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public Double calculaValorLocacao() {
		Double taxa = 150.00;
		Double arCond = 235.00;
		Double calculoKm = getValorKmRodado() * totalKilometros();
		return arCondicionado ? taxa + arCond + calculoKm : taxa + calculoKm;
	}

	@Override
	public String toString() {
		return "VeiculoPasseio [arCondicionado=" + arCondicionado + ", numeroPortas=" + numeroPortas + "]";
	}

}
