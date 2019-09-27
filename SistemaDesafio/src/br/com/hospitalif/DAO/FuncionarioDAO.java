package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Funcionario;

public class FuncionarioDAO {

	public void save(Funcionario f) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Funcionario VALUES(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, f.getLogin());
		stmt.setString(2, f.getSenha()); 
		stmt.setString(3, f.getStatusUsuario()); 
		stmt.execute();
	}
	
	public void removeById(Funcionario f) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Funcionario" + "WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, f.getLogin());
		stmt.setString(2, f.getSenha()); 
		stmt.setString(3, f.getStatusUsuario()); 
		stmt.execute();
	}
	
	public void upadte(Funcionario f) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Funcionario SET(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, f.getLogin());
		stmt.setString(2, f.getSenha()); 
		stmt.setString(3, f.getStatusUsuario()); 
		stmt.execute();
	}
	
	public void select(Funcionario f) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECTs Funcionario VALUES(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, f.getLogin());
		stmt.setString(2, f.getSenha()); 
		stmt.setString(3, f.getStatusUsuario()); 
		stmt.execute();
	}
}
