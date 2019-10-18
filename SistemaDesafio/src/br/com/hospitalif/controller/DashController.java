package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public class DashController extends Main{

    @FXML
    private Button btnEntrada;

    @FXML
    private Button btnEnfermeiro;

    @FXML
    private Button btnEnfermidadePessoal;

    @FXML
    private Tab btnServidores;

    @FXML
    private Button btnEnfermidade;

    @FXML
    private Button btnMedico;

    @FXML
    private Button btnPaciente;

    @FXML
    private Button btnAtendimento;

    @FXML
    private Button btnGerente;

    @FXML
    private Tab btnRecepcao;

    @FXML
    private Button btnFuncionario;

    @FXML
    private Button btnPessoal;

    @FXML
    private Button btnAdm;
    
    @FXML
    private Button btnVolrar;
    
    
    @FXML
    void RegistrarAtendimento(ActionEvent event) throws IOException {
    	openPage(Rotas.ATENDIMENTO);
    }

    @FXML
    void SalvarEnfermidadePessoal(ActionEvent event) throws IOException {
    	openPage(Rotas.ENFEMIDADEPESSOAL);
    }

    @FXML
    void EntradaDePaciente(ActionEvent event) throws IOException {
    	openPage(Rotas.ENTRADA);
    }

    @FXML
    void Atender(ActionEvent event) throws IOException {
    	openPage(Rotas.ATENDENTE);
    }

    @FXML
    void RegistrarEnfermidade(ActionEvent event) throws IOException {
    	openPage(Rotas.ENFERMIDADE);
    }

    @FXML
    void CadastrarPessoa(ActionEvent event) throws IOException {
    	openPage(Rotas.CADASTRODEPESSOA);
    }

    @FXML
    void consultarPaciente(ActionEvent event) throws IOException {
    	openPage(Rotas.PACIENTE);
    }

    @FXML
    void CadastrarAdministrador(ActionEvent event) throws IOException {
    	openPage(Rotas.ADM);
    }

    @FXML
    void CadastrarMedico(ActionEvent event) throws IOException {
    	openPage(Rotas.MEDICO);
    }

    @FXML
    void CadastrarEnfermeiro(ActionEvent event) throws IOException {
    	openPage(Rotas.ENFERMEIRO);
    }

    @FXML
    void CadastrarFuncionario(ActionEvent event) throws IOException {
    	openPage(Rotas.CADASTRODEPESSOA);
    }

    @FXML
    void CadastrarGerente(ActionEvent event) throws IOException {
    	openPage(Rotas.FUNCIONARIO);
    }
    
    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.LOGIN);
    }

}
