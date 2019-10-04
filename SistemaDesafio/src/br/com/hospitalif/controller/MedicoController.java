package br.com.hospitalif.controller;


import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class MedicoController extends Main{

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
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}
