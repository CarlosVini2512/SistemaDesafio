package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroDePessoal {

    @FXML
    private ComboBox<?> buttonIdade;

    @FXML
    private SplitMenuButton buttonSexo;

    @FXML
    private TextArea txtStatus;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private TextField txtNome;

    @FXML
    private ComboBox<?> buttonTipoSanguineo;

    @FXML
    private TextField txtCpf;

    @FXML
    void CadastrarPessoal(ActionEvent event) {

    }

}
