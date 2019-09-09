package br.com.hospitalif.controller;

import java.time.LocalDate;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;


public class Atendimento {

    @FXML
    private DatePicker txtData;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextArea txtComentEnfermeiro;

    @FXML
    private ListView<EnfermidadePessoal> txtDoenca;

    @FXML
    private TextArea txtComentMedico;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField txtAltura;


    @FXML
    void CadastrarAtendimento(ActionEvent event) {
    	LocalDate data = txtData.getValue();
    	String peso = txtPeso.getText();
    	String ComentarioEnfermeiro = txtComentEnfermeiro.getText();  	
    	Callback <?,?> doenca = txtDoenca.getCellFactory();
    	String ComentarioEnf = txtComentMedico.getText();
    	String altura = txtAltura.getText();
    }

    @FXML
    void VoltarTela(ActionEvent event) {

    }

}



