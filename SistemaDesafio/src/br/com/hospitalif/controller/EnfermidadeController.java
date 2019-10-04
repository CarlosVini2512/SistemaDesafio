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

public class EnfermidadeController extends Main{

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private Button btnConsultar;

    @FXML
    private SplitMenuButton btnTipoEnfermidade;


    @FXML
    void ConsultarEnfermidade(ActionEvent event) {
    	
    	String nome = txtNome.getText();
    	String descricao = txtDescricao.getText();
    	String tipoEnf = btnTipoEnfermidade.getId();
    }

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}

