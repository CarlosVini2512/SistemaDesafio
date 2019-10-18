package br.com.hospitalif.model;

public class Gerente extends Funcionario{
	
	private int IdGerente;
	private String cargo;
	
	public int getIdGerente() {
		return this.IdGerente;
	}
	
	public String getCargo() {
		return this.cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
