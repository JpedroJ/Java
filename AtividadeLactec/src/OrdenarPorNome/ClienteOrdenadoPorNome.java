package OrdenarPorNome;

import java.util.Comparator;

import Model.Cliente;

public class ClienteOrdenadoPorNome implements Comparator<Cliente>{

//Classe que deixa os nome por ordem de idade

	@Override
	public int compare(Cliente c1, Cliente c2) {
		return c1.getIdade().compareTo(c2.getIdade());
	}

}
