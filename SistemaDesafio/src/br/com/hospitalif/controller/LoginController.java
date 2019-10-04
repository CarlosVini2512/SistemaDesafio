package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController extends Main{

	 @FXML
	    private TextField txtLogin;

	    @FXML
	    private TextField txtSenha;

	    @FXML
	    private Button btnVoltar;

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
	    void VoltaTela(ActionEvent event) throws IOException {
	    	openPage(Rotas.DASH);
	    }


}





