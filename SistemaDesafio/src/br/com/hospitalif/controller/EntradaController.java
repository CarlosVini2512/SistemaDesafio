package br.com.hospitalif.controller;


import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;

public class EntradaController {

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
    void VoltarTela(ActionEvent event) {
    	
    }
}

