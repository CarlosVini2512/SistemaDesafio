package br.com.hospitalif.conexao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	
	
	
	public String status = "Não conectado!";
	 java.sql.Connection conn = null;
	 String user = "root";
	 String pwd = "";
	 String driverName = "com.mysql.jdbc.Driver";
	 String server = "localhost";
	 String bdName = "hospitalFX";
	 String url = "jdbc:mysql://" + server + ";3306/" + bdName;
	 
	 
	//método para devolver a conexão
	public java.sql.Connection getConnection() {
		try {
			Class.forName(this.driverName);
			this.conn = DriverManager.getConnection(url, user, pwd);
			
			if(conn != null) {
				this.status = "STATUS --> Conectado com Sucesso!";
			} else {
				this.status = "STATUS --> Não concetado!";
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return this.conn;
	}
	
	//Imprimir status da conexão
	public String getStatus() {
		return this.status;
	}
	
	//fechar conexão
	public boolean closeConnection() {
		return false;
	}
	
	//abrir uma conexão
	public void resetConnection() {
		this.closeConnection();
		this.getConnection();
	}
	
}
