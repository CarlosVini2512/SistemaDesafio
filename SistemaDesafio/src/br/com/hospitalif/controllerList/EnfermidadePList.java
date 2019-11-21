package br.com.hospitalif.controllerList;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.EnfermidadePessoalDAO;
import br.com.hospitalif.controller.EnfermidadePessoalController;
import br.com.hospitalif.model.EnfermidadePessoal;
import br.com.hospitalif.util.Rotas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EnfermidadePList extends EnfermidadePessoalController implements Initializable {

    @FXML
    private TableView<EnfermidadePessoal> tableEnfermidadeP;

    @FXML
    private TableColumn<EnfermidadePessoal, String> comentario;

    @FXML
    private TableColumn<EnfermidadePessoal, String> status;
    
    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnEditar;
    
    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;


    @FXML
    void salvarDados(ActionEvent event) throws IOException, SQLException {
	    	String statusDeEnfermidade = txtStatusEnfermidadeP.getText();
	    	String comentario = txtComent.getText();
	    	
	    	EnfermidadePessoal itens = new EnfermidadePessoal();
			EnfermidadePessoalDAO itensDAO = new EnfermidadePessoalDAO();
			EnfermidadePessoal getId = tableEnfermidadeP.getSelectionModel().getSelectedItem();
			itens.setIdEnfermidadePessoal(getId.getIdEnfermidadePessoal());
			itens.setComentario(comentario);
			itens.setStatusEnfermidade(statusDeEnfermidade);
			itensDAO.update(itens);
			openPage(Rotas.ENFERMIDADEPLIST);
		 	
    }

	@FXML
    void voltarTela(ActionEvent event) throws IOException {
    	openPage(Rotas.ENFEMIDADEPESSOAL);
    }

    @FXML
    void excluirDados(ActionEvent event) throws IOException, SQLException {
    	try {
			EnfermidadePessoal excluir = tableEnfermidadeP.getSelectionModel().getSelectedItem();
			EnfermidadePessoalDAO exclui = new EnfermidadePessoalDAO();
			exclui.removeById(excluir.getIdEnfermidadePessoal());
			openPage(Rotas.ENFERMIDADEPLIST);
		} catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void editarDados(ActionEvent event) {
    	try {
			EnfermidadePessoal item = tableEnfermidadeP.getSelectionModel().getSelectedItem();
			txtComent.setText(item.getDescricao());
			txtStatusEnfermidadeP.setText(item.getStatusEnfermidade());
		} catch (NullPointerException e) {
			erroSelecao();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	comentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));
		status.setCellValueFactory(new PropertyValueFactory<>("statusEnfermeiro"));
    	
    	EnfermidadePessoalDAO selecao = new EnfermidadePessoalDAO();
    	List<EnfermidadePessoal> selecaoItens = selecao.select();
    	ObservableList<EnfermidadePessoal> itens = FXCollections.observableArrayList(selecaoItens);
    	tableEnfermidadeP.setItems(itens);
	}		
	
}
