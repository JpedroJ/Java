package br.com.elaborata.firma;

public class CalcularSalario {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
		Funcionario funcionario2 = new Funcionario("Astrogilda", "Mulher do aspone", "R$ " + String.valueOf(8.50 * 40));

		funcionario.setNome("Atanagildo");
		funcionario.setCargo("Aspone");
		funcionario.setSalario("R$ " + String.valueOf((14.5 * 40)));

		System.out.println(funcionario.getNome() + " \t \t" + funcionario2.getNome());
		System.out.println(funcionario.getCargo() + " \t \t" + funcionario2.getCargo());
		System.out.println(funcionario.getSalario() + " \t\t" + funcionario2.getSalario());

	}

}
