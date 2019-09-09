package br.com.hospitalif.controller;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class Paciente {

    @FXML
    private ListView<Entrada> listHistorico;

    @FXML
    private DatePicker dtDataInicio;

    @FXML
    private ListView<EnfermidadePessoal> listDoenca;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnConsultar;

    @FXML
    private DatePicker dtDataFinal;


    @FXML
    void ConsultarPaciente(ActionEvent event) {

    	Callback<?, ?> historico = listHistorico.getCellFactory();
    	LocalDate dataInicial = dtDataInicio.getValue();
    	Callback<?,?> doenca = listDoenca.getCellFactory();
    	LocalDate dataFinal = dtDataFinal.getValue();
    }

    @FXML
    void VoltarTela(ActionEvent event) {

    }

}