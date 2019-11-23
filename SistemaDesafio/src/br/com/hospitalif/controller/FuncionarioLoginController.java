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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FuncionarioLoginController extends Main{

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextArea txtStatusFuncionario;
    

    @FXML
    void CadastrarFuncionario(ActionEvent event) throws SQLException {
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	String statusFunc = txtStatusFuncionario.getText();
    	
    	Medico medico = new Medico();
    	MedicoDAO medicoDAO = new MedicoDAO();
    	medico.setLogin(login);
    	medico.setSenha(senha);
    	medicoDAO.save(medico);

    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}

