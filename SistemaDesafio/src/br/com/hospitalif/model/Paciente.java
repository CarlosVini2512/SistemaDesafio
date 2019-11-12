package br.com.hospitalif.model;

public class Paciente extends Pessoa{

	private int idPaciente;
	private String doenca;
	private String historico;
	

	public int getIdPaciente() {
		return this.idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public String getDoenca() {
		return this.doenca;
	}
	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	
	public String getHistorico() {
		return this.historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
}
