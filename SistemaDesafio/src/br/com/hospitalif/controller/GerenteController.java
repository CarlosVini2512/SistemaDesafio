package br.com.hospitalif.controller;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.GerenteDAO;
import br.com.hospitalif.model.Gerente;
import br.com.hospitalif.util.Rotas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GerenteController extends Main{

    @FXML
    protected TextField txtLogin;

    @FXML
    protected TextField txtSenha;

    @FXML
    protected TextArea txtStatus;
    
    @FXML
    protected TextField txtCargo;

    @FXML
    protected TextField txtNome;

    @FXML
    protected TextField txtCpf;

    @FXML
    protected TextField txtSexo;
    
    @FXML
    protected TextField txtIdade;

    @FXML
	protected TextField txtTipoSanguineo;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnSair;
    
    @FXML
    private Button btnLista;
    
    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

    @FXML
    void CadGerente(ActionEvent event) throws SQLException {
    	try {
    		String nome = txtNome.getText();
    		int idade = Integer.parseInt (txtIdade.getText());
			int CPF = Integer.parseInt(txtCpf.getText());
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
    		gerente.setCPF(CPF);
    		gerente.setTipoSangue(tipoSanguineo);
    		gerente.setSexo(sexo);
    		gerente.setStatusDaPessoa(status);
    		gerente.setCargo(cargo);
    		gerente.setLogin(login);
    		gerente.setSenha(senha);
    		gerenteDAO.save(gerente);
    	} catch (NumberFormatException e) {
			System.out.println("Preencha o campo Vazio");
    	}
    }

    @FXML
    void listaGerente(ActionEvent event) throws IOException {
    	openPage(Rotas.GERENTELIST);
    }
}

