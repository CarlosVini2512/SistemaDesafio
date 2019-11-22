package br.com.hospitalif.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import app.Main;
import br.com.hospitalif.DAO.EntradaDAO;
import br.com.hospitalif.model.Entrada;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class EntradaController extends Main{

    @FXML
    protected TextArea txtStatusDeEntrada;

    @FXML
    protected DatePicker dtDataSaida;

    @FXML
    protected TextArea txtSituacaoPaciente;

    @FXML
	protected DatePicker dtDataEntrada;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnLista;


    @FXML
    void RegistrarEntrada(ActionEvent event) throws SQLException {
    	String statusEntrada = txtStatusDeEntrada.getText();
    	String situacaoPaciente = txtSituacaoPaciente.getText();
    	LocalDate dataEntrada = dtDataEntrada.getValue();
    	LocalDate dataSaida = dtDataSaida.getValue();
    	
    	Entrada entrada = new Entrada();
    	EntradaDAO entradaDAO = new EntradaDAO();
    	entrada.setStatusEntrada(statusEntrada);
    	entrada.setSituacaoDoPaciente(situacaoPaciente);
    	entrada.setData(dataEntrada);
    	entrada.setDataSaida(dataSaida);
    	entradaDAO.save(entrada);
    	
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }
    
    @FXML
    void listarDados(ActionEvent event) throws IOException {
    	openPage(Rotas.ENTRADALIST);
    }
}

