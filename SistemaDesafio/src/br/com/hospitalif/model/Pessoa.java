package br.com.hospitalif.model;

public class Pessoa  {
	
	private int idPessoa;
	private String nome;
	private int cpf;
	private int idade;
	private String tipoSanguineo;
	private String sexo;
	private String statusPessoa;

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
	
	public int getCPF() {
		return this.cpf;
	}
	public void setCPF(int cpf) {
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
	
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String Sx) {
		this.sexo = Sx;
	}
	
	public String getStatusDaPessoa() {
		return this.statusPessoa;
	}
	public void setStatusDaPessoa(String StatusP) {
		this.statusPessoa = StatusP;
	}
	

}
