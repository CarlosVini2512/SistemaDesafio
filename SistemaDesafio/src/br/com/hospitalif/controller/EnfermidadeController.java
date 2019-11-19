package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.EnfermidadeDAO;
import br.com.hospitalif.model.Enfermidade;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EnfermidadeController extends Main{

    @FXML
    private Button btnVoltar;

    @FXML
	protected TextField txtNome;

    @FXML
    protected TextArea txtDescricao;

    @FXML
    protected TextField txtTipoEnfermidade;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnLista;

    
    @FXML
    void ConsultarEnfermidade(ActionEvent event) throws SQLException {
    	
    	String nome = txtNome.getText();
    	String descricao = txtDescricao.getText();
    	String tipo = txtTipoEnfermidade.getText();  
    	
    	Enfermidade enfermidade = new Enfermidade();
    	EnfermidadeDAO enfermidadeDAO = new EnfermidadeDAO();
    	enfermidade.setNome(nome);
    	enfermidade.setDescricao(descricao);
    	enfermidade.setTipo(tipo);
    	enfermidadeDAO.save(enfermidade);
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

    @FXML
    void listarDados(ActionEvent event) throws IOException {
		openPage(Rotas.ENFERMIDADELIST);
    }
}

