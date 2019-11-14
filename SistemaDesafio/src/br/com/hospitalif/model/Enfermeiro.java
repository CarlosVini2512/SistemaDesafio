package br.com.hospitalif.model;

public class Enfermeiro extends Funcionario{
	private int idEnfermeiro;
	private int numeroderegistro;
	
	public int getIdEnfermeiro() {
		return idEnfermeiro;
	}
	
	public void setIdEnfermeiro(int IdEnfermeiro) {
		this.idEnfermeiro = IdEnfermeiro;
	}
	
	public int getNumeroRegistro() {
		return this.numeroderegistro;
	}
	
	public void setNumeroRegistro(int Nregistro) {
		this.numeroderegistro = Nregistro;
	}
	
	
}
