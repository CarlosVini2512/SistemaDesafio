package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.model.Medico;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroFuncionarioController extends Main{

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextArea txtStatus;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnEntrar;


    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);

    }

    @FXML
    void LogarFuncionario(ActionEvent event) throws SQLException {
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	String status = txtStatus.getText();
    	
    	Medico medico = new Medico();    
    	MedicoDAO medicoDAO = new MedicoDAO();
    	medico.setLogin(login);
    	medico.setSenha(senha);
    	medico.setStatusUsuario(status);
    	MedicoDAO.save(medico);
    }

}

