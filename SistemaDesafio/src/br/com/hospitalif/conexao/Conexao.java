package br.com.hospitalif.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
	
	
	
	public String status = "N�o conectado!";
	 java.sql.Connection conn = null;
	 String user = "root";
	 String pwd = "";
	 String driverName = "com.mysql.jdbc.Driver";
	 String server = "localhost";
	 String bdName = "hospitalfx";
	 String url = "jdbc:mysql://" + server + ";3306/" + bdName;
	 
	 
	//m�todo para devolver a conex�o
	public Connection getConnection() {
		try {
			Class.forName(this.driverName);
			this.conn = DriverManager.getConnection(url, user, pwd);
			
			if(conn != null) {
				this.status = "STATUS --> Conectado com Sucesso!";
			} else {
				this.status = "STATUS --> N�o concetado!";
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return this.conn;
	}
	
	//Imprimir status da conex�o
	public String getStatus() {
		return this.status;
	}
	
	//fechar conex�o
	public boolean closeConnection() throws SQLException{
		return false;
	}
	
	//abrir uma conex�o
	public void resetConnection() throws SQLException {
		try {
			this.closeConnection();
			this.getConnection();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

	
}
