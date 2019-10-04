package br.com.hospitalif.controller;

import java.io.IOException;

import app.Main;
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
    void CadastrarPessoa(ActionEvent event) {
    	String status = txtStatus.getText();
    	String nome  = txtNome.getText();
    	String cpf = txtCPF.getText();
    	String tipodesangue = btnTipoSangue.getId();
    	String idade = txtIdade.getText();
    	String sexo = btnSexo.getId();
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);

    }

}


