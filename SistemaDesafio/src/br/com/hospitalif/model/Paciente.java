package br.com.hospitalif.model;

import java.util.List;

public class Paciente {

	private int idPaciente;
	private List EnfermidadePessoal;
	private List Entrada;
	

	public int getIdPaciente() {
		return this.idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public List getEnfermidadePessoal() {
		return this.EnfermidadePessoal;
	}
	public void setEnfermidadePessoal(List EnfermidadeP) {
		this.EnfermidadePessoal = EnfermidadeP;
	}
	
	public List getEntrada() {
		return this.Entrada;
	}
	public void setEntrada(List entrada) {
		this.Entrada = entrada;
	}
}
