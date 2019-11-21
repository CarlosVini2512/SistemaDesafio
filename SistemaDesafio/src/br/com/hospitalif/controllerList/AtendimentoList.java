package br.com.hospitalif.controllerList;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.AtendimentoDAO;
import br.com.hospitalif.controller.AtendimentoController;
import br.com.hospitalif.model.Atendimento;
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

public class AtendimentoList extends AtendimentoController implements Initializable{

    @FXML
    private TableView<Atendimento> tableAtendimento;

    @FXML
    private TableColumn<Atendimento, String> doenca;

    @FXML
    private TableColumn<Atendimento, String> comentEnfermeiro;

    @FXML
    private TableColumn<Atendimento, String> data;

    @FXML
    private TableColumn<Atendimento, String> altura;

    @FXML
    private TableColumn<Atendimento, String> peso;

    @FXML
    private TableColumn<Atendimento, String> comentMedico;

    
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
		openPage(Rotas.ATENDIMENTO);
    }

    @FXML
    void excluirDados(ActionEvent event) {
    	try {
			Atendimento a = tableAtendimento.getSelectionModel().getSelectedItem();
			System.out.println(a.getIdAtendimento());
			AtendimentoDAO adao = new AtendimentoDAO();
			adao.removeById(a.getIdAtendimento());
			openPage(Rotas.ATENDIMENTOLIST);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void editarDados(ActionEvent event) {
    	try {
    		Atendimento a = tableAtendimento.getSelectionModel().getSelectedItem();
    		txtComentEnfermeiro.setText(a.getComentarioEnfermeiro());
    		txtComentMedico.setText(a.getComentarioMedico());
    		txtAltura.setText("" + a.getAltura());
    		txtPeso.setText("" + a.getPeso());
    		txtData.setValue(a.getData());
    		txtDoenca.setText(a.getDoenca());
    	}catch (NullPointerException e) {
    		erroSelecao();
    	}
    }

    @FXML
    void salvarDados(ActionEvent event) {
    	try {
			String ComentarioEnfermeiro = txtComentEnfermeiro.getText();
			String ComentarioMedico = txtComentMedico.getText();
			float altura = Float.parseFloat(txtAltura.getText());
			float peso = Float.parseFloat(txtPeso.getText());
			LocalDate data = txtData.getValue();
			String doenca = txtDoenca.getText();
			
			Atendimento a = new Atendimento();
			AtendimentoDAO atendimetoDAO = new AtendimentoDAO();
			Atendimento getId = tableAtendimento.getSelectionModel().getSelectedItem();
			a.setIdAtendimento(getId.getIdAtendimento());
			a.setComentarioEnfermeiro(ComentarioEnfermeiro);
			a.setComentarioMedico(ComentarioMedico);
			a.setAltura(altura);
			a.setPeso(peso);
			a.setData(data);
			a.setDoenca(doenca);
			atendimetoDAO.update(a);
			openPage(Rotas.ATENDIMENTOLIST);
		} catch (NumberFormatException e1) {
			erroSelecao();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comentMedico.setCellValueFactory(new PropertyValueFactory<>("comentarioMedico"));
		comentEnfermeiro.setCellValueFactory(new PropertyValueFactory<>("comentarioEnfermeiro"));
		peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
		altura.setCellValueFactory(new PropertyValueFactory<>("altura"));
		data.setCellValueFactory(new PropertyValueFactory<>("dData"));
		doenca.setCellValueFactory(new PropertyValueFactory<>("doenca"));
		
		AtendimentoDAO selecao = new AtendimentoDAO();
		List<Atendimento> atendimentos = selecao.select();
		System.out.println("Tamanho " + atendimentos.size());
		ObservableList<Atendimento> itens = FXCollections.observableArrayList(atendimentos);
		tableAtendimento.setItems(itens);
	}

}
