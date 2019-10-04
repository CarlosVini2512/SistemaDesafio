package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class EnfermidadePessoalController extends Main{

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextArea txtStatusEnfermidadeP;

    @FXML
    private TextArea txtComent;

    @FXML
    void SalvarDados(ActionEvent event) {
    	
    	String comentario = txtComent.getText();
    	String StatusEnfPessoal = txtStatusEnfermidadeP.getText();
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}

