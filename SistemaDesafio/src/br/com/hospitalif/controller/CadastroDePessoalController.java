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
import javafx.scene.control.SplitMenuButton;
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
    private SplitMenuButton btnTipoSangue;

    @FXML
    private TextField txtIdade;

    @FXML
    private SplitMenuButton btnSexo;

    @FXML
    void CadastrarPessoa(ActionEvent event) throws IOException, SQLException {
    	String status = txtStatus.getText();
    	String nome  = txtNome.getText();
    	String cpf = txtCPF.getText();
    	String tipodesangue = btnTipoSangue.getId();
    	int idade = Integer.parseInt(txtIdade.getText());
    	String sexo = btnSexo.getId();
    	
    	Medico medico = new Medico();
    	MedicoDAO medicoDAO = new MedicoDAO();
    	medico.setStatusDaPessoa(status);
    	medico.setNome(nome);
    	medico.setCPF(cpf);
    	medico.setTipoSangue(tipodesangue);
    	medico.setIdade(idade);
    	medico.setSexo(sexo);
    	medicoDAO.save(medico);
    	
    	openPage(Rotas.FUNCIONARIO);
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	
    	openPage(Rotas.DASH);
    }

}


