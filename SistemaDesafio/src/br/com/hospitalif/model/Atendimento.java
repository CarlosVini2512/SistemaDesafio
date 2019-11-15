package br.com.hospitalif.model;

import java.time.LocalDate;

public class Atendimento {

	private int idAtendimento;
	private String comentarioEnfermeiro;
	private String comentarioMedico;
	private float peso;
	private float altura;
	private LocalDate data;
	private String doenca;
	
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
	
	public LocalDate getData() {
		return this.data;
	}
	public void setData(LocalDate d) {
		this.data = d;
	}
	
	public String getDoenca() {
		return this.doenca;
	}
	public void setDoenca (String doenca) {
		this.doenca = doenca;
	}
	
}
