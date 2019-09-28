package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public class Dash extends Main{

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
    void RegistrarAtendimento(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

    @FXML
    void SalvarEnfermidadePessoal(ActionEvent event) {

    }

    @FXML
    void EntradaDePaciente(ActionEvent event) {

    }

    @FXML
    void Atender(ActionEvent event) {

    }

    @FXML
    void RegistrarEnfermidade(ActionEvent event) {

    }

    @FXML
    void CadastrarPessoa(ActionEvent event) {

    }

    @FXML
    void consultarPaciente(ActionEvent event) {

    }

    @FXML
    void CadastrarAdministrador(ActionEvent event) {

    }

    @FXML
    void CadastrarMedico(ActionEvent event) {

    }

    @FXML
    void CadastrarEnfermeiro(ActionEvent event) {

    }

    @FXML
    void CadastrarFuncionario(ActionEvent event) {

    }

    @FXML
    void CadastrarGerente(ActionEvent event) {

    }

}
