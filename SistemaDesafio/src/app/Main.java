package app;

import java.io.IOException;
import java.sql.SQLException;

import br.com.hospitalif.util.Rotas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

	static Stage stageAtual;
	static FXMLLoader loader;
	
	@Override
	public void start(Stage Stage) throws Exception {
		stageAtual = Stage;	
		
		try {	
				openPage(Rotas.LOGIN);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public void openPage(String rota) throws IOException {
			loader = new FXMLLoader(getClass().getResource(rota));				 	
			Scene scene = new Scene(loader.load());
			stageAtual.setScene(scene);
			stageAtual.show();				
	}
		
	
	public static void main(String[] args) throws SQLException {
		launch(args);

		/*Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());*/
				
	}
	
	//tratamento de erros
	
	public void erroSelecao(){
    	Alert alert = new Alert(Alert.AlertType.WARNING);
    	alert.setTitle("Erro");
    	alert.setHeaderText("Erro ao selecionar item");
    	alert.setContentText("Selecione ao menos um campo");
    	alert.show();
    }
}
