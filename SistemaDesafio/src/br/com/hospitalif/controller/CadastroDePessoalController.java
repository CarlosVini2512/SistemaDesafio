package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.PessoaDAO;
import br.com.hospitalif.model.Pessoa;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroDePessoalController extends Main {

	@FXML
    private TextArea txtStatus;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtSexo;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtTipoSangue;

    @FXML
    void CadastrarPessoa(ActionEvent event) throws IOException, SQLException {
    	String status = txtStatus.getText();
    	String nome  = txtNome.getText();
    	String cpf = txtCPF.getText();
    	String tipodesangue = txtTipoSangue.getText();
    	int idade = Integer.parseInt(txtIdade.getText());
    	String sexo = txtSexo.getText();
    	
    	Pessoa pessoa = new Pessoa();
    	PessoaDAO pessoaDAO = new PessoaDAO();
    	pessoa.setStatusDaPessoa(status);
    	pessoa.setNome(nome);
    	pessoa.setCPF(cpf);
    	pessoa.setTipoSangue(tipodesangue);
    	pessoa.setIdade(idade);
    	pessoa.setSexo(sexo);
    	pessoaDAO.save(pessoa);
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	
    	openPage(Rotas.DASH);
    }

}


