package br.com.hospitalif.controllerList;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.EnfermidadeDAO;
import br.com.hospitalif.controller.EnfermidadeController;
import br.com.hospitalif.model.Enfermidade;
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

public class EnfermidadeList extends EnfermidadeController implements Initializable {

    @FXML
    private TableView<Enfermidade> tableEnfermidade;

    @FXML
    private TableColumn<Enfermidade, String> tipo;

    @FXML
    private TableColumn<Enfermidade, String> nome;

    @FXML
    private TableColumn<Enfermidade, String> descricao;
    
    @FXML
    private Button btnSalvar;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnEditar;
    
    
    @FXML
    void voltarTela(ActionEvent event) throws IOException {
		openPage(Rotas.ENFERMIDADE);
    }

    @FXML
    void excluirDados(ActionEvent event) throws SQLException, IOException {
    	try {
			Enfermidade exclui = tableEnfermidade.getSelectionModel().getSelectedItem();
			EnfermidadeDAO excluir = new EnfermidadeDAO();
			excluir.removeById(exclui.getIdEnfermidade());
			openPage(Rotas.ENFERMIDADELIST);
		}catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void editarDados(ActionEvent event) {
    	try {
			Enfermidade item = tableEnfermidade.getSelectionModel().getSelectedItem();
			txtNome.setText(item.getNome());
			txtDescricao.setText(item.getDescricao());
			txtTipoEnfermidade.setText(item.getTipo());
		} catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void salvarDados(ActionEvent event) throws SQLException, IOException {
    	try {
	    	String nome =  txtNome.getText();
	    	String descricao = txtDescricao.getText();
	    	String tipo = txtTipoEnfermidade.getText();
	    	
			Enfermidade itens = new Enfermidade();
			EnfermidadeDAO itensDAO = new EnfermidadeDAO();
			Enfermidade getId = tableEnfermidade.getSelectionModel().getSelectedItem();
			itens.setIdEnfermidade(getId.getIdEnfermidade());
			itens.setNome(nome);
			itens.setTipo(tipo);
			itens.setDescricao(descricao);
			itensDAO.update(itens);
			openPage(Rotas.ENFERMIDADELIST);
		} catch (NumberFormatException e1) {
			erroSelecao();
		} 
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		EnfermidadeDAO selecao = new EnfermidadeDAO();
		List<Enfermidade> selecaoItens = selecao.select();
		ObservableList<Enfermidade> itens = FXCollections.observableArrayList(selecaoItens);
		tableEnfermidade.setItems(itens);
	}

}