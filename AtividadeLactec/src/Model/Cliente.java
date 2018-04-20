package Model;

public class Cliente {

	//Atributos, Get's e Set's
	public int idCLiente;
	public String nome;
	public String idade;
	public String telefone;

	public Cliente() {
		super();
	}

	public Cliente(int idCLiente, String nome, String idade, String telefone) {
		super();
		this.idCLiente = idCLiente;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
	}

	public int getIdCLiente() {
		return idCLiente;
	}

	public void setIdCLiente(int idCLiente) {
		this.idCLiente = idCLiente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
