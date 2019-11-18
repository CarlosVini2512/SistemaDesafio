package br.com.hospitalif.controllerList;
	
	import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.controller.MedicoController;
import br.com.hospitalif.model.Medico;
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

	public class MedicoList extends MedicoController implements Initializable {

		 @FXML
		private TableView<Medico> tableMedico;
		 
	    @FXML
	    private TableColumn<Medico, String> sangue;

	    @FXML
	    private TableColumn<Medico, String> idade;
	    
	    @FXML
	    private TableColumn<Medico, String> senha;

	    @FXML
	    private TableColumn<Medico, String> especialidade;

	    @FXML
	    private TableColumn<Medico, String> numRegistro;	    

	    @FXML
	    private TableColumn<Medico, String> cpf;

	    @FXML
	    private TableColumn<Medico, String> nome;

	    @FXML
	    private TableColumn<Medico, String> sexo;

	    @FXML
	    private TableColumn<Medico, String> login;
	    
	    @FXML
	    private Button btnSalvar;
	    
	    @FXML
	    private Button btnVoltar;
	    
	    @FXML
	    private Button btnExcluir;
	    
	    @FXML
	    private Button btnEditar;

	    
	    
	    @FXML
	    void salvarDados(ActionEvent event) throws IOException, SQLException {
			try {
				String nome = txtNome.getText();
				int CPF = Integer.parseInt(txtCpf.getText());
				int idade = Integer.parseInt(txtIdade.getText());
				String tipoSanguineo = txtTipoSanguineo.getText();
				String sexo = txtSexo.getText();
				int numRegistro = Integer.parseInt(txtNumRegistro.getText());
				String especialidade = txtEspecialidade.getText();
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				
				Medico medicoItens = new Medico();
				MedicoDAO medicoItensDAO = new MedicoDAO();
				Medico getId = tableMedico.getSelectionModel().getSelectedItem();
				medicoItens.setIdFuncionario(getId.getIdFuncionario());
				medicoItens.setNome(nome);
				medicoItens.setCPF(CPF);
				medicoItens.setIdade(idade);
				medicoItens.setTipoSangue(tipoSanguineo);
				medicoItens.setSexo(sexo);
				medicoItens.setNumeroRegistro(numRegistro);
				medicoItens.setEspecialidade(especialidade);
				medicoItens.setLogin(login);
				medicoItens.setSenha(senha);
				medicoItensDAO.update(medicoItens);
				openPage(Rotas.MEDICOLIST);
				
			} catch (NumberFormatException e1) {
				erroSelecao();
			}
	    }
	  

		@FXML
	    void editarDados(ActionEvent event) {
			try {
				Medico item = tableMedico.getSelectionModel().getSelectedItem();
				txtNome.setText(item.getNome());
				txtCpf.setText("" + item.getCPF());
				txtIdade.setText("" + item.getIdade());
				txtTipoSanguineo.setText(item.getTipoSangue());
				txtSexo.setText(item.getSexo());
				txtNumRegistro.setText("" + item.getNumeroRegistro());
				txtEspecialidade.setText(item.getEspecialidade());
				txtLogin.setText(item.getLogin());
				txtSenha.setText(item.getSenha());
				
			} catch (NullPointerException e) {
				erroSelecao();
			}
	    }
	    
	    @FXML
	    void excluirDados(ActionEvent event) {
	    	try {
				Medico excluir = tableMedico.getSelectionModel().getSelectedItem();
				MedicoDAO exclui = new MedicoDAO();
				exclui.removeById(excluir.getIdFuncionario());
				openPage(Rotas.MEDICOLIST);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				erroSelecao();
			}
	    }
	    
	    @FXML
	    void voltarTela(ActionEvent event) throws IOException {
			openPage(Rotas.MEDICO);

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
			numRegistro.setCellValueFactory(new PropertyValueFactory<>("numeroDeRegistro"));
			especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
			
			senha.setVisible(false);
			
			MedicoDAO selecao = new MedicoDAO();
			List<Medico> selecaoItens = selecao.select();
			ObservableList<Medico> itens = FXCollections.observableArrayList(selecaoItens);
			tableMedico.setItems(itens);			
		}

	}



