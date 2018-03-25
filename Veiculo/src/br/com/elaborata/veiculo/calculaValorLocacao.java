package br.com.elaborata.veiculo;

import java.util.Scanner;

public class calculaValorLocacao {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Digite quantos kilometros vc rodou: ");
		Veiculo veiculo = new Veiculo("ACG - 2211", "Chevrolet", "Celtinha", "2017", "50 km rodados", "Iniciou em 0",
				String.valueOf("Valor da locação ficou em R$ " + (235 + (3.75 * in.nextInt()))));

		/*Veiculo veiculo2 = new Veiculo("JPS - 1997", "Ford", "Delrey", "1970", "165 km rodados", "Iniciou em 0",
				String.valueOf("Valor da locação ficou em R$ " + (150 + (3.75 * 165))));

		Veiculo veiculo3 = new Veiculo("AHF - 3344", "Volkswagem", "Carreta", "2000", "200 km rodados", "Iniciou em 0",
				String.valueOf("Valor da locação ficou em R$ " + (333 + (4.25 * 200))));*/

		VeiculoPasseio veiculoPasseio = new VeiculoPasseio();
		VeiculoPasseio veiculoPasseio2 = new VeiculoPasseio();

		System.out.println("Deseja ar-condicionado no veiculo? ");
		veiculoPasseio.setArcondicionado(in.next());
		System.out.println("Quantas portas deseja o veiculo? 2 ou 4 portas ");
		veiculoPasseio.setNumerodeportas (in.next());

/*		veiculoPasseio2.setArcondicionado("Não");
		veiculoPasseio2.setNumerodeportas("2 Portas");
*/
/*		VeiculoCarga veiculoCarga = new VeiculoCarga();

		veiculoCarga.setCapacidade("2 toneladas");*/
		
		System.out.println("--Custo de locação de um veiculo de passeio com arcondicionado--");
		System.out.println(veiculo.getPlaca() + "\n" + veiculo.getMarca() + "\n" + veiculo.getModelo() + "\n"
				+ veiculo.getAno() + "\n" + veiculo.getKmrodado() + "\n" + veiculo.getKminicial() + "\n"
				+ veiculo.getKmfinal() + "\n" + "Ar-condicionado: " + veiculoPasseio.getArcondicionado() + "\n"
				+"Numero de portas: " +veiculoPasseio.getNumerodeportas());
		
		System.out.println();
		/*System.out.println("--Custo de locação de um veiculo de passeio sem arcondicionado--");
		System.out.println(veiculo2.getPlaca() + "\n" + veiculo2.getMarca() + "\n" + veiculo2.getModelo() + "\n"
				+ veiculo2.getAno() + "\n" + veiculo2.getKmrodado() + "\n" + veiculo2.getKminicial() + "\n"
				+ veiculo2.getKmfinal() + "\n" + "Tem Ar-condicionado? " + veiculoPasseio2.getArcondicionado() + "\n"
				+ veiculoPasseio2.getNumerodeportas());
		System.out.println();
		System.out.println("--Custo de um veiculo de carga--");
		System.out.println(veiculo3.getPlaca() + "\n" + veiculo3.getMarca() + "\n" + veiculo3.getModelo() + "\n"
				+ veiculo3.getAno() + "\n" + veiculo3.getKmrodado() + "\n" + veiculo3.getKminicial() + "\n"
				+ veiculo3.getKmfinal() + "\n" + veiculoCarga.getCapacidade());*/
	}

}
