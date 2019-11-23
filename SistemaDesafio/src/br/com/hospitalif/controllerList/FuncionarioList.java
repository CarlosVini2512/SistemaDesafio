package br.com.hospitalif.controllerList;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.FuncionarioDAO;
import br.com.hospitalif.controller.FuncionarioController;
import br.com.hospitalif.model.Funcionario;
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

public class FuncionarioList extends FuncionarioController implements Initializable{

    @FXML
    private TableView<Funcionario> tableFuncionario;
    
    @FXML
    private TableColumn<Funcionario, String> sangue;

    @FXML
    private TableColumn<Funcionario, String> idade;

    @FXML
    private TableColumn<Funcionario, String> cpf;

    @FXML
    private TableColumn<Funcionario, String> nome;

    @FXML
    private TableColumn<Funcionario, String> sexo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnEditar;

    @FXML
    private TableColumn<?, ?> status;
    
    @FXML
    void salvarDados(ActionEvent event) throws IOException, SQLException {
    	try {
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String StatusPessoa = txtStatus.getText();
			String Sanguineo = txtTipoSangue.getText();
			String sexo = txtSexo.getText();
			
			Funcionario itens = new Funcionario();
			FuncionarioDAO itensDAO = new FuncionarioDAO();
			Funcionario getId = tableFuncionario.getSelectionModel().getSelectedItem();
			itens.setIdFuncionario(getId.getIdFuncionario());
			itens.setNome(nome);
			itens.setCPF(CPF);
			itens.setIdade(idade);
			itens.setStatusDaPessoa(StatusPessoa);
			itens.setTipoSangue(Sanguineo);
			itens.setSexo(sexo);
			itensDAO.update(itens);
			openPage(Rotas.FUNCIONARIOLIST);
		} catch (NumberFormatException e1) {
			erroSelecao();
		}
    }
    
    @FXML
    void excluirDados(ActionEvent event) throws IOException, SQLException {
    	try {
			Funcionario excluir = tableFuncionario.getSelectionModel().getSelectedItem();
			FuncionarioDAO exclui = new FuncionarioDAO();
			exclui.removeById(excluir.getIdFuncionario());
			openPage(Rotas.FUNCIONARIOLIST);
		}catch (NullPointerException e) {
			erroSelecao();
		}
    }

    @FXML
    void editarDados(ActionEvent event) {
    	try {
			Funcionario item = tableFuncionario.getSelectionModel().getSelectedItem();
			txtNome.setText(item.getNome());
			txtCPF.setText("" + item.getCPF());
			txtIdade.setText("" + item.getIdade());
			txtStatus.setText(item.getStatusDaPessoa());
			txtTipoSangue.setText(item.getTipoSangue());
			txtSexo.setText(item.getSexo());
		} catch (NullPointerException e) {
			erroSelecao();
		}
    } 

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
		openPage(Rotas.FUNCIONARIO);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
			sangue.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
			sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
			status.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
		
			FuncionarioDAO selecao = new FuncionarioDAO();
			List<Funcionario> selecaoItens = selecao.select();
			ObservableList<Funcionario> itens = FXCollections.observableArrayList(selecaoItens);
			tableFuncionario.setItems(itens);
		
			selecaoItens = selecao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			erroSelecao();
		} 
	}

}
