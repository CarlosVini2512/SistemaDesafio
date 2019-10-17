package br.com.hospitalif.model;

public class EnfermidadePessoal extends Enfermidade{

	private int idEnfermidadePessoal;
	private String comentario;
	private String statusDeEnfermidade;
	
		public int getIdEnfermidadePessoal() {
			return this.idEnfermidadePessoal;
		}
		public void setIdEnfermidadePessoal(int idEnfermidadeP) {
			this.idEnfermidadePessoal = idEnfermidadeP;
		}
		
		public String getComentario() {
			return this.comentario;
		}
		public void setComentario(String comentario) {
			this.comentario = comentario;
		}
		
		public String getStatusEnfermidade() {
			return this.statusDeEnfermidade;
		}
		public void setStatusEnfermidade(String statusDeEnfermidade) {
			this.statusDeEnfermidade = statusDeEnfermidade;
		}
		
}
