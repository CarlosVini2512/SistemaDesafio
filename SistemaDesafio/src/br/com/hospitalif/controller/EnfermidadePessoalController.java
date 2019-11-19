package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.EnfermidadeDAO;
import br.com.hospitalif.model.EnfermidadePessoal;
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
    private Button btnLista;
    
    @FXML
    protected TextArea txtStatusEnfermidadeP;

    @FXML
	protected TextArea txtComent;

    @FXML
    void SalvarDados(ActionEvent event) throws SQLException {
    	
    	String Comentario = txtComent.getText();
    	String StatusEnfPessoal = txtStatusEnfermidadeP.getText();
    	
    	EnfermidadePessoal enfermidadeP = new EnfermidadePessoal();
    	EnfermidadeDAO enfermidadeDAO = new EnfermidadeDAO(); 
    	enfermidadeP.setComentario(Comentario);
    	enfermidadeP.setStatusEnfermidade(StatusEnfPessoal);
    	enfermidadeDAO.save(enfermidadeP);
    }
    
    @FXML
    void listarDados(ActionEvent event) throws IOException {
    	openPage(Rotas.ENFERMIDADEPLIST);
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}

