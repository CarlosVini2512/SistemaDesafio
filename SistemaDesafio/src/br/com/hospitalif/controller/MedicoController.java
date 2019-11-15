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
import javafx.scene.control.TextField;

public class MedicoController extends Main{

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumRegistro;

    @FXML
    private TextField txtEspecialidade;

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
    void CadastrarMedico(ActionEvent event) throws SQLException, IOException {
    	try {
    		String nome = txtNome.getText();
    		int idade = Integer.parseInt (txtIdade.getText());
    		String cpf = txtCpf.getText();
    		String tipoSanguineo = txtTipoSanguineo.getText();
    		String sexo = txtSexo.getText();
    		String login = txtLogin.getText();
    		String senha = txtSenha.getText();
    		int numeroRegistro = Integer.parseInt (txtNumRegistro.getText());
    		String especialidade = txtEspecialidade.getText();
    		
    	
    		Medico medico = new Medico();
    		MedicoDAO medicoDAO = new MedicoDAO();
    		medico.setNome(nome);
    		medico.setIdade(idade);
    		medico.setCPF(cpf);
    		medico.setTipoSangue(tipoSanguineo);
    		medico.setSexo(sexo);
    		medico.setLogin(login);
    		medico.setSenha(senha);
    		medico.setNumeroRegistro(numeroRegistro);
    		medico.setEspecialidade(especialidade);
    		medicoDAO.save(medico);
			openPage(Rotas.DASH);
    	} catch (NumberFormatException e) {
			System.out.println("Preencha o campo Vazio");
		}catch(NullPointerException e) {
			System.out.println("Preencha o campo Vazio");
		}
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}
