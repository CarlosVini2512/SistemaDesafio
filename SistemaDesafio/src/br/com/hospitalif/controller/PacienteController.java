package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.model.Paciente;
import br.com.hospitalif.util.Rotas;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteController extends Main {

    @FXML
    private TextArea txtHistorico;

    @FXML
    private TextArea txtDoenca;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCadastrar;

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
    void CadastrarPaciente(ActionEvent event) throws SQLException {
    	try {
    		String nome = txtNome.getText();
    		String cpf = txtCpf.getText();
    		int idade = Integer.parseInt (txtIdade.getText());
    		String tipoSangue = txtTipoSanguineo.getText();
    		String sexo = txtSexo.getText();
    		String historico = txtHistorico.getText();
    		String doenca = txtDoenca.getText();
    	
    		Paciente paciente = new Paciente();
    		PacienteDAO pacienteDAO = new PacienteDAO();  
    		paciente.setNome(nome);
    		paciente.setCPF(cpf);
    		paciente.setIdade(idade);
    		paciente.setSexo(sexo);
    		paciente.setTipoSangue(tipoSangue);
    		paciente.setHistorico(historico);
    		paciente.setDoenca(doenca);
    		pacienteDAO.save(paciente);
    	} catch (NumberFormatException e) {
			System.out.println("Campo idade vazio");
		}
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);

    }

}
