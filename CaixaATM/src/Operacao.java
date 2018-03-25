import java.io.Serializable;
import java.util.Date;

public class Operacao implements Serializable {
	
	private static final long serialVersionUID = -8817028865136414526L;

	private char tipo;
	private Date data;
	private double valor;
	private double saldoAnterior;
	private double saldoAtual;
	
	public Operacao() {
		super();
	}

	public Operacao(char tipo, Date data, double valor) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

}
