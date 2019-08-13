package br.com.hospitalif.model;

public class Funcionario extends Pessoa{

	private int idFuncionario;
	private String login;
	private String senha;
	private String statusDeUsuario;
	
	public int getIdFuncionario() {
		return this.idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getStatusUsuario() {
		return this.statusDeUsuario;
	}
	public void setStatusUsuario(String statusDeUsuario) {
		this.statusDeUsuario = statusDeUsuario;
	}
	
}
