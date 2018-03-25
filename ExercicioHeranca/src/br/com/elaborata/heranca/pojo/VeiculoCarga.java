/**
 * 
 */
package br.com.elaborata.heranca.pojo;

/**
 * @author Roque Junior
 *
 */
public class VeiculoCarga extends Veiculo {

	private Integer capacidade;

	public VeiculoCarga() {
	}

	public VeiculoCarga(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Double calculaValorLocacao() {
		return 333.00 + (getValorKmRodado() * totalKilometros());
	}

	@Override
	public String toString() {
		return "VeiculoCarga [capacidade=" + capacidade + "]";
	}

}
