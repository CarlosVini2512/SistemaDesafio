package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.FuncionarioDAO;
import br.com.hospitalif.model.Funcionario;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FuncionarioController extends Main {

	@FXML
	protected TextArea txtStatus;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Button btnLista;

    @FXML
	protected TextField txtNome;

    @FXML
    protected TextField txtCPF;

    @FXML
    protected TextField txtSexo;

    @FXML
    protected TextField txtIdade;

    @FXML
    protected TextField txtTipoSangue;

    @FXML
    void cadastrar(ActionEvent event) throws IOException, SQLException {
    	try { 
    		String nome  = txtNome.getText();
    		int cpf = Integer.parseInt(txtCPF.getText());
    		int idade = Integer.parseInt(txtIdade.getText());
    		String tipodesangue = txtTipoSangue.getText();
    		String sexo = txtSexo.getText();
    		String status = txtStatus.getText();
    	
    		Funcionario funcionario = new Funcionario();
    		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    		funcionario.setNome(nome);
    		funcionario.setCPF(cpf);
    		funcionario.setIdade(idade);
    		funcionario.setTipoSangue(tipodesangue);
    		funcionario.setSexo(sexo);
    		funcionario.setStatusDaPessoa(status);
    		FuncionarioDAO.save(funcionario);
    	} catch (NumberFormatException e1) {
			System.out.println("Formato de dado inválido");
		}
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }
    
    @FXML
    void listarDados(ActionEvent event) throws IOException {
    	openPage(Rotas.FUNCIONARIOLIST);
    }

}


