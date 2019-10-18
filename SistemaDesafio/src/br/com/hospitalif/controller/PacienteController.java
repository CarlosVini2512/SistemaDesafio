package br.com.hospitalif.controller;

import java.io.IOException;
import java.time.LocalDate;

import app.Main;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.model.Paciente;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class PacienteController extends Main{

		@FXML
	    private DatePicker dtDataInicio;

	    @FXML
	    private TextArea txtHistorico;

	    @FXML
	    private TextArea txtDoenca;

	    @FXML
	    private Button btnVoltar;

	    @FXML
	    private Button btnConsultar;

	    @FXML
	    private DatePicker dtDataFinal;


    @FXML
    void ConsultarPaciente(ActionEvent event) {

    	String historico = txtHistorico.getText();
    	LocalDate dataInicial = dtDataInicio.getValue();
    	String doenca = txtDoenca.getText();
    	LocalDate dataFinal = dtDataFinal.getValue();
    	
    	Paciente paciente = new Paciente();
    	PacienteDAO pacienteDAO = new PacienteDAO();    
    	paciente.setHistorico(historico);
    	paciente.setDoenca(doenca);
    	pacienteDAO.save(paciente);
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}