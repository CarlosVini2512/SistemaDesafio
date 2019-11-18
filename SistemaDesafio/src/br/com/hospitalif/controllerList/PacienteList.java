package br.com.hospitalif.controllerList;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.controller.PacienteController;
import br.com.hospitalif.model.Paciente;
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

	public class PacienteList extends PacienteController implements Initializable {

	    @FXML
	    private TableView<Paciente> tablePaciente;
	    
	    @FXML
	    private TableColumn<Paciente, String> sangue;

	    @FXML
	    private TableColumn<Paciente, String> idade;

	    @FXML
	    private TableColumn<Paciente, String> doenca;

	    @FXML
	    private TableColumn<Paciente, String> cpf;

	    @FXML
	    private TableColumn<Paciente, String> historico;

	    @FXML
	    private TableColumn<Paciente, String> nome;

	    @FXML
	    private TableColumn<Paciente, String> sexo;

	    @FXML
	    private Button btnExcluir;

	    @FXML
	    private Button btnEditar;

	    @FXML
	    private Button btnVoltar;
	    
	    @FXML
	    private Button btnSalvar;

	    @FXML
	    void voltarTela(ActionEvent event) throws IOException {
			openPage(Rotas.PACIENTE);
	    }

	    @FXML
	    void excluirDados(ActionEvent event) throws IOException {
	    	try {
				Paciente excluir = tablePaciente.getSelectionModel().getSelectedItem();
				PacienteDAO exclui = new PacienteDAO();
				exclui.removeById(excluir.getIdPaciente());
				openPage(Rotas.PACIENTELIST);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				erroSelecao();
			}
	    }

	    @FXML
	    void editarDados(ActionEvent event) {
	    	try {
				Paciente item = tablePaciente.getSelectionModel().getSelectedItem();
				txtNome.setText(item.getNome());
				txtCpf.setText("" + item.getCPF());
				txtIdade.setText("" + item.getIdade());
				txtTipoSanguineo.setText(item.getTipoSangue());
				txtSexo.setText(item.getSexo());
				txtDoenca.setText(item.getDoenca());
				txtHistorico.setText(item.getHistorico());
			} catch (NullPointerException e) {
				erroSelecao();
			}
	    }

	    @FXML
	    void salvarDados(ActionEvent event) {
	    	try {
				String nome = txtNome.getText();
				int CPF = Integer.parseInt(txtCpf.getText());
				int idade = Integer.parseInt(txtIdade.getText());
				String tipoSanguineo = txtTipoSanguineo.getText();
				String sexo = txtSexo.getText();
				String doenca = txtDoenca.getText();
				String historico = txtHistorico.getText();
				
				Paciente itens = new Paciente();
				PacienteDAO itensDAO = new PacienteDAO();
				Paciente getId = tablePaciente.getSelectionModel().getSelectedItem();
				itens.setIdPaciente(getId.getIdPaciente());
				itens.setNome(nome);
				itens.setCPF(CPF);
				itens.setIdade(idade);
				itens.setTipoSangue(tipoSanguineo);
				itens.setSexo(sexo);
				itens.setDoenca(doenca);
				itens.setHistorico(historico);
				itensDAO.update(itens);
				openPage(Rotas.PACIENTELIST);
			} catch (NumberFormatException e1) {
				erroSelecao();
			} catch (SQLException e2) {

			} catch (IOException e3) {
			}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			try {			
				nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
				cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
				idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
				sangue.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
				sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
				doenca.setCellValueFactory(new PropertyValueFactory<>("doenca"));
				historico.setCellValueFactory(new PropertyValueFactory<>("historico"));

				List<Paciente> selecaoItens = null;
				ObservableList<Paciente> itens = FXCollections.observableArrayList(selecaoItens);
				tablePaciente.setItems(itens);
			}catch(NullPointerException e) {
				System.out.println("");
			}
		}

	}


