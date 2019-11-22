package br.com.hospitalif.controllerList;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.EntradaDAO;
import br.com.hospitalif.controller.EntradaController;
import br.com.hospitalif.model.Entrada;
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

public class EntradaList extends EntradaController implements Initializable {

    @FXML
    private TableView<Entrada> tableEntrada;
    
    @FXML
    private TableColumn<Entrada, String> situacaoPaciente;

    @FXML
    private TableColumn<Entrada, String> dataEntrada;

    @FXML
    private TableColumn<Entrada, String> statusEntrada;

    @FXML
    private TableColumn<Entrada, String> dataSaida;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnEditar;

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
		openPage(Rotas.ENTRADA);
    }

    @FXML
    void excluirDados(ActionEvent event) throws IOException, SQLException {
    	try {
			Entrada excluir = tableEntrada.getSelectionModel().getSelectedItem();
			EntradaDAO exclui = new EntradaDAO();
			exclui.removeById(excluir.getIdEntrada());
			openPage(Rotas.ENTRADALIST);
    	} catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void editarDados(ActionEvent event) {
    	try {
			Entrada item = tableEntrada.getSelectionModel().getSelectedItem();
			dtDataEntrada.setValue(item.getDataEntrada());
			dtDataSaida.setValue(item.getDataSaida());
			txtSituacaoPaciente.setText(item.getSituacaoDoPaciente());
			txtStatusDeEntrada.setText(item.getStatusEntrada());
		} catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void salvarDados(ActionEvent event) throws IOException, SQLException {
    	try {
			LocalDate dataEntrada = dtDataEntrada.getValue();
			LocalDate dataSaida = dtDataSaida.getValue();
			String StatusPaciente = txtSituacaoPaciente.getText();
			String StatusEntrada = txtStatusDeEntrada.getText();
			
			Entrada itens = new Entrada();
			EntradaDAO itensDAO = new EntradaDAO();
			Entrada getId = tableEntrada.getSelectionModel().getSelectedItem();
			itens.setIdEntrada(getId.getIdEntrada());
			itens.setDataEntrada(dataEntrada);
			itens.setDataSaida(dataSaida);
			itens.setSituacaoDoPaciente(StatusPaciente);
			itens.setStatusEntrada(StatusEntrada);
			itensDAO.update(itens);
			openPage(Rotas.ENTRADALIST);
		} catch (NumberFormatException e1) {
			erroSelecao();
		} 
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dataEntrada.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));
		dataSaida.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		statusEntrada.setCellValueFactory(new PropertyValueFactory<>("statusEntrada"));
		situacaoPaciente.setCellValueFactory(new PropertyValueFactory<>("situacaoPaciente"));
		
		EntradaDAO selecao = new EntradaDAO();
		List<Entrada> selecaoItens = selecao.select();
		ObservableList<Entrada> itens = FXCollections.observableArrayList(selecaoItens);
		tableEntrada.setItems(itens);
	}

}
