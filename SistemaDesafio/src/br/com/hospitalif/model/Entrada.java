package br.com.hospitalif.model;

import java.util.Date;
import java.util.List;

public class Entrada extends Atendimento{

	private int idEntrada;
	private Date dataEntrada;
	private Date dataSaida;
	private String statusDeEntrada;
	private List<Atendimento> situacaoDoPaciente;
	
	public int getIdEntrada() {
		return this.idEntrada;
	}
	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}
	
	public Date getDataEntrada() {
		return this.dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Date getDataSaida() {
		return this.dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public String getStatusEntrada() {
		return this.statusDeEntrada;
	}
	public void setStatusEntrada(String statusEntrada) {
		this.statusDeEntrada = statusEntrada;
	}
	
	public List<Atendimento> getSituacaoDoPaciente() {
		return this.situacaoDoPaciente;
	}
	public void setSituacaoDoPaciente(List<Atendimento> situacaoPaciente) {
		this.situacaoDoPaciente = situacaoPaciente;
	}
}
