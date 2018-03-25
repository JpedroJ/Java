/**
 * 
 */
package br.com.elaborata.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "entrevistados")
public class Entrevistado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true)
	private int codigo;
	
	@Column(name = "idade")
	private int idade;
	
	@Column(name = "genero", nullable = false , length = 20)
	private Genero genero;
	
	@Column(name = "time_coracao", nullable = false, length = 20)
	private TimeCoracao timeCoracao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "codigo_pesquisa", nullable = false) 
	private Pesquisa pesquisa;
	
	
	



	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public final int getIdade() {
		return idade;
	}

	public final void setIdade(int idade) {
		this.idade = idade;
	}

	public final Genero getGenero() {
		return genero;
	}

	public final void setGenero(Genero genero) {
		this.genero = genero;
	}

	public final TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}

	public final void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}

	public final Pesquisa getPesquisa() {
		return pesquisa;
	}

	public final void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}


	public Entrevistado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entrevistado(int codigo, int idade, Genero genero, TimeCoracao timeCoracao, Pesquisa pesquisa) {
		super();
		this.codigo = codigo;
		this.idade = idade;
		this.genero = genero;
		this.timeCoracao = timeCoracao;
		this.pesquisa = pesquisa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((timeCoracao == null) ? 0 : timeCoracao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrevistado other = (Entrevistado) obj;
		if (genero != other.genero)
			return false;
		if (timeCoracao != other.timeCoracao)
			return false;
		return true;
	}
}