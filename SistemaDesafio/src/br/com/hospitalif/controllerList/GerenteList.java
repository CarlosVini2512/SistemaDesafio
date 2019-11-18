package br.com.hospitalif.controllerList;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.GerenteDAO;
import br.com.hospitalif.controller.GerenteController;
import br.com.hospitalif.model.Gerente;
import br.com.hospitalif.util.Rotas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GerenteList extends GerenteController implements Initializable {

	 @FXML
	private TableView<Gerente> tableGerente;
	 
    @FXML
    private TableColumn<Gerente, String> senha;

    @FXML
    private TableColumn<Gerente, String> cargo;

    @FXML
    private TableColumn<Gerente, String> nome;

    @FXML
    private TableColumn<Gerente, String> sangue;

    @FXML
    private TableColumn<Gerente, String> cpf;

    @FXML
    private TableColumn<Gerente, String> idade;

    @FXML
    private TableColumn<Gerente, String> login;

    @FXML
    private TableColumn<Gerente, String> status;

    @FXML
    private TableColumn<Gerente, String> sexo;

    @FXML
    private Button btnExcluir;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnSalvar;
    
    @FXML
    private Button btnEditar;

    
    @FXML
    void salvarDados(ActionEvent event) throws SQLException, IOException {   
    	try {
    		String nome = txtNome.getText();
    		int CPF = Integer.parseInt(txtCpf.getText());
    		int idade = Integer.parseInt(txtIdade.getText());
    		String tipoSanguineo = txtTipoSanguineo.getText();
    		String status = txtStatus.getText();
    		String sexo = txtSexo.getText();
    		String cargo = txtCargo.getText();
    		String login = txtLogin.getText();
    		String senha = txtSenha.getText();

			
    		Gerente gerenteList = new Gerente();
			GerenteDAO gerenteListDAO = new GerenteDAO();
			Gerente getId = tableGerente.getSelectionModel().getSelectedItem();
			gerenteList.setIdFuncionario(getId.getIdFuncionario());
			gerenteList.setNome(nome);
			gerenteList.setCPF(CPF);
			gerenteList.setIdade(idade);
			gerenteList.setCargo(cargo);
			gerenteList.setTipoSangue(tipoSanguineo);
			gerenteList.setSexo(sexo);
			gerenteList.setLogin(login);
			gerenteList.setSenha(senha);
			gerenteList.setStatusDaPessoa(status);
			gerenteListDAO.update(gerenteList);
			openPage(Rotas.GERENTELIST);
		
    	} catch (NumberFormatException e1) {
			erroSelecao();
		} catch (SQLException e2) {

		} catch (IOException e3) {

		}
    }
    
	@FXML
    void voltarTela(ActionEvent event) throws IOException {
		openPage(Rotas.GERENTE);
    }

	@FXML
    void excluirDados(ActionEvent event) throws IOException, SQLException {
		Gerente excluir = tableGerente.getSelectionModel().getSelectedItem();
		GerenteDAO exclui = new GerenteDAO();
		exclui.removeById(excluir.getIdFuncionario());
		openPage(Rotas.GERENTELIST);
    }
	
	 @FXML
	    void editarDados(ActionEvent event) {
		 try {
				Gerente item = tableGerente.getSelectionModel().getSelectedItem();
				txtCargo.setText(item.getCargo());
				txtLogin.setText(item.getLogin());
				txtSenha.setText(item.getSenha());
				txtStatus.setText(item.getStatusDaPessoa());
				txtNome.setText(item.getNome());
				txtCpf.setText("" + item.getCPF());
				txtIdade.setText("" + item.getIdade());
				txtTipoSanguineo.setText(item.getTipoSangue());
				txtSexo.setText(item.getSexo());
				
			} catch (NullPointerException e) {
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
		status.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
		login.setCellValueFactory(new PropertyValueFactory<>("login"));
		senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		
		senha.setVisible(false);

		GerenteDAO selecao = new GerenteDAO();
		List<Gerente> selecaoItens = selecao.select();
		ObservableList<Gerente> itens = FXCollections.observableArrayList(selecaoItens);
		tableGerente.setItems(itens);
	}

}



