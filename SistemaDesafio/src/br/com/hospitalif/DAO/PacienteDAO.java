package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Paciente;

public class PacienteDAO {

	public void save(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Paciente VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setList(1, p.getDoenca());
		stmt.setList(2, p.getHistorico()); 
		stmt.execute();
	}
	
	public void removeById(Paciente p) {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Paciente" + "WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setList(1, p.getDoenca());
		stmt.setList(2, p.getHistorico());
		stmt.execute();
	}
	
	public void upadte(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Paciente SET(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setList(1, p.getDoenca());
		stmt.setList(2, p.getHistorico()); 
		stmt.execute();
	}
	
	public void select(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT Paciente VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setList(1, p.getDoenca());
		stmt.setList(2, p.getHistorico()); 
		stmt.execute();
	}
}
