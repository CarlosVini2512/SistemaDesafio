package br.com.hospitalif.model;

import java.time.LocalDate;

public class Entrada extends Atendimento{

	private int idEntrada;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String statusDeEntrada;
	private String situacaoDoPaciente;
	
	public int getIdEntrada() {
		return this.idEntrada;
	}
	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}
	
	public LocalDate getDataEntrada() {
		return this.dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public LocalDate getDataSaida() {
		return this.dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public String getStatusEntrada() {
		return this.statusDeEntrada;
	}
	public void setStatusEntrada(String statusEntrada) {
		this.statusDeEntrada = statusEntrada;
	}
	
	public String getSituacaoDoPaciente() {
		return this.situacaoDoPaciente;
	}
	public void setSituacaoDoPaciente(String situacaoPaciente) {
		this.situacaoDoPaciente = situacaoPaciente;
	}
	
}
