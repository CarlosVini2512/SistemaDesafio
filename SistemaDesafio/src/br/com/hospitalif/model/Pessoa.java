package br.com.hospitalif.model;

public class Pessoa {
	
	private int idPessoa;
	private String nome;
	private String cpf;
	private int idade;
	private String tipoSanguineo;
	private char sexo;
	private String StatusPessoa;

	public int getIdPessoa() {
		return this.idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
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
	
	public int getIdade() {
		return this.idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getTipoSangue() {
		return this.tipoSanguineo;
	}
	public void setTipoSangue(String tipoSangue) {
		this.tipoSanguineo = tipoSangue;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	public void setSexo(char Sx) {
		this.sexo = Sx;
	}
	
	public String getStatusDaPessoa() {
		return this.StatusPessoa;
	}
	public void setStatusDaPessoa(String StatusP) {
		this.StatusPessoa = StatusP;
	}
	

}
