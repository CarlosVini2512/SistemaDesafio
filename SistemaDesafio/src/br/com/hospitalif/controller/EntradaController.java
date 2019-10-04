package br.com.hospitalif.controller;


import java.io.IOException;
import java.time.LocalDate;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;

public class EntradaController extends Main{

    @FXML
    private Button btnVoltar;

    @FXML
    private TextArea txtStatusDeEntrada;

    @FXML
    private DatePicker dtDataSaida;

    @FXML
    private SplitMenuButton btnSituacaoPaciente;

    @FXML
    private DatePicker dtDataEntrada;

    @FXML
    private Button btnRegistrar;


    @FXML
    void RegistrarEntrada(ActionEvent event) {
    	String statusEntrada = txtStatusDeEntrada.getText();
    	String situacaoPaciente = btnSituacaoPaciente.getId();
    	LocalDate dataEntrada = dtDataEntrada.getValue();
    	LocalDate dataSaida = dtDataSaida.getValue();
    	
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }
}

