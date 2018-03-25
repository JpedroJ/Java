import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria implements Serializable {
	
	private static final long serialVersionUID = 5679240522316507709L;

	private String numero;
	private double saldo;
	private List<Operacao> operacoes;
	
	public ContaBancaria() {
		operacoes = new ArrayList<>();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}

}
