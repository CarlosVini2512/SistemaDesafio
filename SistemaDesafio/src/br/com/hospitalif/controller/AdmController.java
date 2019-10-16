package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdmController extends Main {

	@FXML
	private Button btnVoltar;
	
    @FXML
    private Button buttonCadastroFuncionario;

    @FXML
    void CadastrarFuncionario(ActionEvent event) throws IOException {
    	openPage(Rotas.CADASTRODEPESSOA);
    }
    
    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }
}


