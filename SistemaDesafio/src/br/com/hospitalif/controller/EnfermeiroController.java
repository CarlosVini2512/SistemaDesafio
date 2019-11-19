package br.com.hospitalif.controller;


import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.EnfermeiroDAO;
import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.model.Enfermeiro;
import br.com.hospitalif.model.Medico;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EnfermeiroController extends Main{
    
    
        @FXML
        private TextField txtLogin;

        @FXML
        private TextField txtSenha;

        @FXML
        private Button btnVoltar;

        @FXML
        private TextField txtNome;

        @FXML
        private TextField txtCpf;

        @FXML
        private TextField txtSexo;

        @FXML
        private TextField txtNumDeRegistro;

        @FXML
        private TextField txtIdade;

        @FXML
        private TextField txtTipoSanguineo;

        @FXML
        private Button btnEntrar;
        
        @FXML
        private Button btnLista;

        @FXML
        void LogarEnfermeiro(ActionEvent event) throws SQLException {
        	String nome = txtNome.getText();
        	int idade = Integer.parseInt (txtIdade.getText());
			int CPF = Integer.parseInt(txtCpf.getText());
        	String tipoSanguineo = txtTipoSanguineo.getText();
        	String sexo = txtSexo.getText();
        	String login = txtLogin.getText();
        	String senha = txtSenha.getText();
        	int numRegistro = Integer.parseInt(txtNumDeRegistro.getText());
        	
        	Enfermeiro enfermeiro = new Enfermeiro();
        	EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        	enfermeiro.setNome(nome);
        	enfermeiro.setIdade(idade);
        	enfermeiro.setCPF(CPF);
        	enfermeiro.setTipoSangue(tipoSanguineo);
        	enfermeiro.setSexo(sexo);
        	enfermeiro.setLogin(login);
        	enfermeiro.setSenha(senha);
        	enfermeiro.setNumeroRegistro(numRegistro);
        	enfermeiroDAO.save(enfermeiro);       	  
        }
        
        @FXML
        void listarDados(ActionEvent event) throws IOException {
    		openPage(Rotas.ENFERMEIROLIST);
        }

        @FXML
        void VoltarTela(ActionEvent event) throws IOException {
        	openPage(Rotas.DASH);
        }

}
