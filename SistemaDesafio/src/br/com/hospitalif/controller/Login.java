package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    void LogarUsuario(ActionEvent event) {
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	//Alert msgg = new Alert(Alert.AlertType.INFORMATION, msg);
    	//msgg.setContentText("Minha msg aqui!");
    	//msgg.setHeaderText("Header aqui");
    	//msgg.show();
    }
  
}


