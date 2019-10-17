package br.com.hospitalif.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController extends Main{

    @FXML
    private TextField txtLogin;

    @FXML
    private Hyperlink btnEsqueciSenha;

    @FXML
    private PasswordField txtSenha;
    
    @FXML
    private RadioButton btnLembrar;

    @FXML
    private Button btnEntrar;

    @FXML
    void LogarUsuario(ActionEvent event) throws IOException {
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	//Alert msgg = new Alert(Alert.AlertType.INFORMATION, msg);
    	//msgg.setContentText("Minha msg aqui!");
    	//msgg.setHeaderText("Header aqui");
    	//msgg.show();
    	openPage(Rotas.DASH);
    }

    @FXML
    void EsqueciSenha(ActionEvent event) {

    }

    @FXML
    void LembrarUsuario(ActionEvent event) {

    }

}

