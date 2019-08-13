package br.com.hospitalif.model;

public class Medico extends Funcionario{

		private int numeroderegistro;
		private String especialidade;
		
		public int getNumeroRegistro() {
			return this.numeroderegistro;
		}
		public void setNumeroRegistro(int Nregistro) {
			this.numeroderegistro = Nregistro;
		}
		
		public String getEspecialidade() {
			return this.especialidade;
		}
		public void setEspecialidade(String Especialidade) {
			this.especialidade = Especialidade;
		}
		
}
