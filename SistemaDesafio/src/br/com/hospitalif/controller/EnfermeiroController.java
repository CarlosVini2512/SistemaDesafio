package br.com.hospitalif.controller;


import java.io.IOException;
import java.sql.SQLException;

import app.Main;
import br.com.hospitalif.DAO.EnfermeiroDAO;
import br.com.hospitalif.model.Enfermeiro;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EnfermeiroController extends Main{

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField txtNumDeRegistro;

    @FXML
    private Button btnEntrar;
    

    @FXML
    void LogarEnfermeiro(ActionEvent event) throws SQLException {
    	int numRegistro = Integer.parseInt(txtNumDeRegistro.getText());
   
    	Enfermeiro enfermeiro = new Enfermeiro();
    	EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
    	enfermeiro.setNumeroRegistro(numRegistro);
    	enfermeiroDAO.save(enfermeiro);
    } 

    @FXML
    void VoltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.DASH);
    }

}
