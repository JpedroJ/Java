/**
 * 
 */
package br.com.elaborata.controle;

import br.com.elaborata.modelo.Entrevistado;
import br.com.elaborata.modelo.Genero;

/**
 * Classe que armazena as informações do modelo de dados<br>
 * 
 * @author Roque Junior
 *
 */
public class Entrevista {

	public static Integer qtdeTorcedores = 0;
	public static Integer totalIdade = 0;
	public static Double mediaIdade = 0.0;
	public static Integer qtdeHomens = 0;
	public static Integer qtdeMulheres = 0;
	public static Integer qtdeAtletico = 0;
	public static Integer qtdeCoritiba = 0;
	public static Integer qtdeParana = 0;
	public static Integer qtdeOutros = 0;

	/**
	 * Método que adiciona um entrevistado para o calculo da pesquisa
	 * 
	 * @param entrevistado
	 *            : Entrevistado
	 */
	public static void addEntrevistado(Entrevistado entrevistado) {
		// Incrementar a quantidade de torcedores
		qtdeTorcedores++;

		// Incrementa a idade dos torcedores
		totalIdade += entrevistado.getIdade();

		mediaIdade = totalIdade.doubleValue() / qtdeTorcedores.doubleValue();

		// Verificar a quantidade de homens e mulheres
		if (entrevistado.getGenero() == Genero.MASCULINO) {
			qtdeHomens++;
		} else {
			qtdeMulheres++;
		}

		// Verifica a quantidade de torcedores por time do caração
		switch (entrevistado.getTimeCoracao()) {
		case ATLETICO:
			qtdeAtletico++;
			break;

		case CORITIBA:
			qtdeCoritiba++;
			break;

		case PARANA:
			qtdeParana++;
			break;

		case OUTROS:
			qtdeOutros++;
			break;
		}
	}

}
