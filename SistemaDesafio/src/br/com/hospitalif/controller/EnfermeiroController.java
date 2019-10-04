package br.com.hospitalif.controller;


import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EnfermeiroController extends Main{

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
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}
