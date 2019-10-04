package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroFuncionarioController extends Main{

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
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);

    }

    @FXML
    void LogarFuncionario(ActionEvent event) {
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	String status = txtStatus.getText();
    }

}

