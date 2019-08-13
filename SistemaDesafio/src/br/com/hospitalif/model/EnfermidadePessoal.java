package br.com.hospitalif.model;

public class EnfermidadePessoal extends Enfermidade{

	private int idEnfermidadePessoal;
	private String comentario;
	private String statusDeEnfermidade;
	
		public int getIdEnfermidadePessoal() {
			return this.idEnfermidadePessoal;
		}
		public void setEnfermidadePessoal(int idEnfermidadeP) {
			this.idEnfermidadePessoal = idEnfermidadeP;
		}
		
		public String getComentario() {
			return this.comentario;
		}
		public void setComentario(String coment) {
			this.comentario = coment;
		}
		
		public String getStatusEnfermidade() {
			return this.statusDeEnfermidade;
		}
		public void setStatusEnfermidade(String statusEnf) {
			this.statusDeEnfermidade = statusEnf;
		}
		
}
