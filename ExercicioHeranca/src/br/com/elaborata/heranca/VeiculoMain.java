/**
 * 
 */
package br.com.elaborata.heranca;

import java.util.Scanner;

import br.com.elaborata.heranca.pojo.VeiculoCarga;
import br.com.elaborata.heranca.pojo.VeiculoPasseio;

/**
 * @author Roque Junior
 *
 */
public class VeiculoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		do {

			System.out.println("**************************");
			System.out.println("    1 - Veiculo Passeio   ");
			System.out.println("    2 - Veiculo Carga     ");
			System.out.println("    3 - Sair              ");
			System.out.println("**************************");

			/*switch (teclado.nextLine()) {
			case "1":

				break;
			case "2":

				break;
			case "3":

				break;

			default:
				break;
			}*/

			VeiculoPasseio veiculoPasseio = new VeiculoPasseio(true, 5);

			veiculoPasseio.setKmInicial(121112);
			veiculoPasseio.setKmFinal(121312);
			veiculoPasseio.setValorKmRodado(3.75); // 1135.00

			VeiculoCarga veiculoCarga = new VeiculoCarga(6);

			veiculoCarga.setKmInicial(133201);
			veiculoCarga.setKmFinal(133401);
			veiculoCarga.setValorKmRodado(4.25); // 1183.00

			System.out.println("O valor da locação do veículo passeio é: " + veiculoPasseio.calculaValorLocacao());

			System.out.println("O Valor da locação do veículo carga é: " + veiculoCarga.calculaValorLocacao());

			System.out.println(veiculoPasseio);
			System.out.println(veiculoCarga);
break;
		} while (true);

	}

}
