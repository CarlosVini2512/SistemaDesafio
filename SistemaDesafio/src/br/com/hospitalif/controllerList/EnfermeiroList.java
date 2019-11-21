package br.com.hospitalif.controllerList;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.EnfermeiroDAO;
import br.com.hospitalif.controller.MedicoController;
import br.com.hospitalif.model.Enfermeiro;
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

public class EnfermeiroList extends MedicoController implements Initializable {

    @FXML
    private TableView<Enfermeiro> tableEnfermeiro;
    
    @FXML
    private TableColumn<Enfermeiro, String> nome;

    @FXML
    private TableColumn<Enfermeiro, String> login;

    @FXML
    private TableColumn<Enfermeiro, String> sangue;

    @FXML
    private TableColumn<Enfermeiro, String> idade;

    @FXML
    private TableColumn<Enfermeiro, String> senha;

    @FXML
    private TableColumn<Enfermeiro, String> numRegistro;

    @FXML
    private TableColumn<Enfermeiro, String> cpf;

    @FXML
    private TableColumn<Enfermeiro, String> sexo;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnSalvar;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnExcluir;

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
		openPage(Rotas.DASH);
    }

    @FXML
    void excluirDados(ActionEvent event) throws IOException {
    	try {
			Enfermeiro excluir = tableEnfermeiro.getSelectionModel().getSelectedItem();
			EnfermeiroDAO exclui = new EnfermeiroDAO();
			exclui.removeById(excluir.getIdEnfermeiro());
			openPage(Rotas.ENFERMEIROLIST);
		} catch (SQLException e) {
		} catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void editarDados(ActionEvent event) {
    	try {
			Enfermeiro item = tableEnfermeiro.getSelectionModel().getSelectedItem();
			txtNome.setText(item.getNome());
			txtCpf.setText("" + item.getCPF());
			txtIdade.setText("" + item.getIdade());
			txtTipoSanguineo.setText(item.getTipoSangue());
			txtSexo.setText(item.getSexo());
			txtLogin.setText(item.getLogin());
			txtSenha.setText(item.getSenha());
			txtNumRegistro.setText("" + item.getNumeroRegistro());
		} catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void salvarDados(ActionEvent event) throws IOException, SQLException {
    	try {
			String numRegistro = txtNumRegistro.getText();
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCpf.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String tipoSanguineo = txtTipoSanguineo.getText();
			String sexo = txtSexo.getText();
			
			Enfermeiro itens = new Enfermeiro();
			EnfermeiroDAO itensDAO = new EnfermeiroDAO();
			Enfermeiro getId = tableEnfermeiro.getSelectionModel().getSelectedItem();
			itens.setIdEnfermeiro(getId.getIdEnfermeiro());
			itens.setNumeroRegistro(numRegistro);
			itens.setLogin(login);
			itens.setSenha(senha);
			itens.setNome(nome);
			itens.setCPF(CPF);
			itens.setIdade(idade);
			itens.setTipoSangue(tipoSanguineo);
			itens.setSexo(sexo);
			itensDAO.update(itens);
			openPage(Rotas.ENFERMEIROLIST);
    	} catch (NumberFormatException e1) {
    		erroSelecao();
    	} 
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
		sangue.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
		sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		login.setCellValueFactory(new PropertyValueFactory<>("login"));
		senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		numRegistro.setCellValueFactory(new PropertyValueFactory<>("numeroRegistro"));
		
		EnfermeiroDAO selecao = new EnfermeiroDAO();
		List<Enfermeiro> selecaoItens = selecao.select();
		ObservableList<Enfermeiro> itens = FXCollections.observableArrayList(selecaoItens);
		tableEnfermeiro.setItems(itens);		
	}

}
