package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FuncionarioController extends Main{

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnEntrar;

    @FXML
    private TextArea txtStatusFuncionario;
    

    @FXML
    void LogarFuncionario(ActionEvent event) {
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	String statusFunc = txtStatusFuncionario.getText();

    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}

