package br.com.hospitalif.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class MedicoController {

    @FXML
    private SplitMenuButton btnEspecialidade;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtNumRegistro;

    @FXML
    private Button btnEntrar;


    @FXML
    void LogarMedico(ActionEvent event) {
    	String especialidade = btnEspecialidade.getId();
    	String numeroRegistro = txtNumRegistro.getText();

    }

    @FXML
    void VoltarTela(ActionEvent event) {

    }

}
