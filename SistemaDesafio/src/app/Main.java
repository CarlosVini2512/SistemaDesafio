package app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.util.Rotas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static Stage stageAtual;
	static FXMLLoader loader;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		// FXMLLoader loader = new FXMLLoader(getClass().getResource(Rotas.DASH));
		
		stageAtual = stage;
		
		
		/*Parent root = loader.load();
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("/css/app.css").toExternalForm());
		stage.setScene(scene);
		stage.show();*/
		openPage(Rotas.DASH);
		
	}
	
	public void openPage(String rota) throws IOException {
		loader = new FXMLLoader(getClass().getResource(rota));
					 	
			Scene scene = new Scene(loader.load());
			stageAtual.setScene(scene);
			stageAtual.show();				
	}
		
	
	public static void main(String[] args) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		launch(args);
				
	}
}
