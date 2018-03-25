package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_bebidas")
public class Bebida implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "codigo", unique = true, nullable = false)
	private int codigo;
	@Column(name = "bebida", nullable = false, length = 30)
	private String bebida;
	@Column(name = "materiaPrima", nullable = false, length = 30)
	private String materiaPrima;
	@Column(name = "tradicionalidade", nullable = false, length = 30)
	private String tradicionalidade;
	@Column(name = "teorAlcoolico", nullable = false, length = 30)
	private String teorAlcoolico;

	public Bebida() {
	}

	public Bebida(String bebida, String materiaPrima, String tradicionalidade, String teorAlcoolico) {
		this.bebida = bebida;
		this.materiaPrima = materiaPrima;
		this.tradicionalidade = tradicionalidade;
		this.teorAlcoolico = teorAlcoolico;
	}
	public int getCodigo(){
		return codigo;
	}
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public String getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(String materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public String getTradicionalidade() {
		return tradicionalidade;
	}

	public void setTradicionalidade(String tradicionalidade) {
		this.tradicionalidade = tradicionalidade;
	}

	public String getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(String teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}
}