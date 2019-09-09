package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroFuncionario {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextArea txtStatus;

    @FXML
    private Button buttonSair;

    @FXML
    private Button buttonEntrar;


    @FXML
    void VoltarTela(ActionEvent event) {
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	String status = txtStatus.getText();

    }

    @FXML
    void LogarFuncionario(ActionEvent event) {

    }

}

