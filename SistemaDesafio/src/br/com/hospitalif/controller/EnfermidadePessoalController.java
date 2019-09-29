package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class EnfermidadePessoalController {

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextArea txtStatusEnfermidadeP;

    @FXML
    private TextArea txtComent;

    @FXML
    void SalvarDados(ActionEvent event) {
    	
    	String comentario = txtComent.getText();
    	String StatusEnfPessoal = txtStatusEnfermidadeP.getText();
    }

    @FXML
    void VoltarTela(ActionEvent event) {

    }

}

