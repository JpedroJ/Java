package br.com.elaborata.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
@Table(name = "pesquisas")
public class Pesquisa implements Serializable {

	
	private static final long serialVersionUID = 6907245554135950479L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true)
	private Integer codigo;
	
	@Column(name= "data_pesquisa")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPesquisa;
	@OneToMany(fetch = FetchType.LAZY,mappedBy= "pesquisa", cascade = CascadeType.ALL)
	private Set<Entrevistado> entrevistados = new HashSet<>(0);
	public final Integer getCodigo() {
		return codigo;
	}

	public final void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public final Date getDataPesquisa() {
		return dataPesquisa;
	}

	public final void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public final Set<Entrevistado> getEntrevistados() {
		return entrevistados;
	}

	public final void setEntrevistados(Set<Entrevistado> entrevistados) {
		this.entrevistados = entrevistados;
	}
	
	
}
