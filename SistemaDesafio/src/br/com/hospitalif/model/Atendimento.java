package br.com.hospitalif.model;

import java.util.Date;
import java.util.List;

public class Atendimento {

	private int idAtendimento;
	private String comentarioEnfermeiro;
	private String comentarioMedico;
	private float peso;
	private float altura;
	private Date data;
	private List<EnfermidadePessoal> doenca;
	
	public int getIdAtendimento() {
		return this.idAtendimento;
	}
	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	
	public String getComentarioEnfermeiro() {
		return this.comentarioEnfermeiro;
	}
	public void setComentarioEnfermeiro(String comentarioEnfermeiro) {
		this.comentarioEnfermeiro = comentarioEnfermeiro;
	}
	
	public String getComentarioMedico() {
		return this.comentarioMedico;
	}
	public void setComentarioMedico(String comentarioEnfermeiro) {
		this.comentarioEnfermeiro = comentarioEnfermeiro;
	}
	
	public float getPeso() {
		return this.peso;
	}
	public void setPeso(float p) {
		this.peso = p;
	}
	
	public float getAltura() {
		return this.altura;
	}
	public void setAltura(float a) {
		this.altura = a;
	}
	
	public Date getData() {
		return this.data;
	}
	public void setData(Date d) {
		this.data = d;
	}
	
	public List<EnfermidadePessoal> getDoenca() {
		return this.doenca;
	}
	public void setDoenca(List<EnfermidadePessoal> doenca) {
		this.doenca = doenca;
	}
	
}
