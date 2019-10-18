package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import app.Main;
import br.com.hospitalif.DAO.AtendimentoDAO;
import br.com.hospitalif.model.Atendimento;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;


public class AtendimentoController extends Main{

	@FXML
    private DatePicker txtData;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextArea txtComentEnfermeiro;

    @FXML
    private TextArea txtDoenca;

    @FXML
    private TextArea txtComentMedico;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField txtAltura;


    @FXML
    void CadastrarAtendimento(ActionEvent event) throws IOException, SQLException {
    	LocalDate data = txtData.getValue();
    	float peso = Float.parseFloat(txtPeso.getText());
    	String ComentarioEnfermeiro = txtComentEnfermeiro.getText();  	
    	String doenca = txtDoenca.getText();
    	String ComentarioMedico = txtComentMedico.getText();
    	float altura = Float.parseFloat(txtAltura.getText());
    	
    	Atendimento atendimento = new Atendimento();
    	AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
    	//atendimento.setData(data);
    	atendimento.setPeso(peso);
    	atendimento.setComentarioEnfermeiro(ComentarioEnfermeiro);
    	atendimento.setDoenca(doenca);
    	atendimento.setComentarioMedico(ComentarioMedico);
    	atendimento.setAltura(altura);
    	atendimentoDAO.save(atendimento);
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);

    }

}



