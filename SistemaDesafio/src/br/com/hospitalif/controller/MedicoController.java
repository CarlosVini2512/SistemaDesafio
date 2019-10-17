package br.com.hospitalif.controller;


import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.model.Medico;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class MedicoController extends Main{

    @FXML
    private SplitMenuButton btnEspecialidade;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtNumRegistro;

    @FXML
    private Button btnEntrar;


    @FXML
    void LogarMedico(ActionEvent event) throws SQLException {
    	String especialidade = btnEspecialidade.getId();
    	int numeroRegistro = Integer.parseInt (txtNumRegistro.getText());
    	
    	Medico medico = new Medico();
    	MedicoDAO medicoDAO = new MedicoDAO();
    	medico.setEspecialidade(especialidade);
    	medico.setNumeroRegistro(numeroRegistro);
    	medicoDAO.save(medico);

    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}
