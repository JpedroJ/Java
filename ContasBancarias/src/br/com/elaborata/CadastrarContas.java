package br.com.elaborata;

public class CadastrarContas {

	public static void main(String[] args) {
		ContaBancaria contaBancaria = new ContaBancaria();
		ContaBancaria contaBancaria2 = new ContaBancaria(1000.00);
		
		System.out.println(contaBancaria.getSaldo());

		contaBancaria.setBanco("Banco Internacional");
		contaBancaria.setAgencia("Agencia Internacional");
		contaBancaria.setNumero(123456);
		
		contaBancaria2.setBanco("Banco Internacional 1");
		contaBancaria2.setAgencia("Agencia Internacional 1");
		contaBancaria2.setNumero(5050050);

		contaBancaria.depositar(150.00);
		contaBancaria2.depositar(150.00);
		
		System.out.println(contaBancaria.getSaldo());
		contaBancaria.sacar(70.00);
		System.out.println(contaBancaria.getSaldo());
		
/*		contaBancaria.sacar(150.00) ? System.out.println(contaBancaria.getSaldo()) : System.out.println("Limite atingido"));
*/		
		if(contaBancaria.sacar(700.00)){
			System.out.println(contaBancaria.getSaldo());
		}else{
			System.out.println("Saldo insuficiente - "+contaBancaria.getSaldo());
		}
		System.out.println(contaBancaria.getSaldo());
		System.out.println("Segunda conta");
		System.out.println(contaBancaria2.getSaldo());
		if(contaBancaria2.sacar(700.00)){
			System.out.println(contaBancaria2.getSaldo());
		}else {
			System.out.println("Saldo insuficiente - "+contaBancaria2.getSaldo());
		}
		
	}

}
