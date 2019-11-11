package br.com.hospitalif.controller;

import javafx.event.ActionEvent;

import java.sql.SQLException;

import br.com.hospitalif.DAO.GerenteDAO;
import br.com.hospitalif.model.Gerente;
import br.com.hospitalif.util.Rotas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GerenteController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextArea txtStatus;
    
    @FXML
    private TextField txtCargo;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtSexo;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtTipoSanguineo;

    @FXML
    private Button btnEntrar;


    @FXML
    void VoltarTela(ActionEvent event) {
    	openPage(Rotas.DASH);
    }

    @FXML
    void CadGerente(ActionEvent event) throws SQLException {
    	String nome = txtNome.getText();
    	int idade = Integer.parseInt (txtIdade.getText());
    	String cpf = txtCpf.getText();
    	String tipoSanguineo = txtTipoSanguineo.getText();
    	String sexo = txtSexo.getText();
    	String status = txtStatus.getText();
    	String cargo = txtCargo.getText();
    	String login = txtLogin.getText();
    	String senha = txtSenha.getText();
    	
    	Gerente gerente = new Gerente();
    	GerenteDAO gerenteDAO = new GerenteDAO();
    	gerente.setNome(nome);
    	gerente.setIdade(idade);
    	gerente.setCPF(cpf);
    	gerente.setTipoSangue(tipoSanguineo);
    	gerente.setSexo(sexo);
    	gerente.setStatusDaPessoa(status);
    	gerente.setCargo(cargo);
    	gerente.setLogin(login);
    	gerente.setSenha(senha);
    	gerenteDAO.save(gerente);
    }

}

