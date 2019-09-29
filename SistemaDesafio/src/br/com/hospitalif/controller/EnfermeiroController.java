package br.com.hospitalif.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EnfermeiroController {

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField txtNumDeRegistro;

    @FXML
    private Button btnEntrar;
    

    @FXML
    void LogarEnfermeiro(ActionEvent event) {
    	String numRegistro = txtNumDeRegistro.getText();
    }

    @FXML
    void VoltarTela(ActionEvent event) {

    }

}
