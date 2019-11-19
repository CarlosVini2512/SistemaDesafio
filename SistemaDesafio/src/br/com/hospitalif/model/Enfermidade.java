package br.com.hospitalif.model;

public class Enfermidade {

	private int IdEnfermidade;
	private String nome;
	private String tipo;
	private String descricao;
	
	public int getIdEnfermidade() {
		return this.IdEnfermidade;
	}
	public void setIdEnfermidade(int idEnfermidade) {
		this.IdEnfermidade = idEnfermidade;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String desc) {
		this.descricao = desc;
	}
}
