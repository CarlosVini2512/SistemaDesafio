package br.com.hospitalif.model;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private String endereco;

	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String n) {
		this.nome = n;
	}
	
	public String getCPF() {
		return this.cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String end) {
		this.endereco = end;
	}

	public void status() {
		System.out.println("Pessoa:");
		System.out.println("Nome:" + this.nome);
		System.out.println("CPF:" + this.cpf);
	}
}
