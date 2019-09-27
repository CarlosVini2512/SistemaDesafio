package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Atendimento;

public class AtendimentoDAO {

	public void save(Atendimento a) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Atendimento VALUES(?,?,?,?,?,?)";
		//seta valores
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(2, a.getComentarioEnfermeiro()); 
		stmt.setString(3, a.getComentarioMedico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,new Date(a.getData().getTime()));
//		stmt.setList(7, a.getDoenca());
		
		//executa
		stmt.execute();
	}
	

	public void removeById(Atendimento a) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Atendimento WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(2, a.getComentarioEnfermeiro()); 
		stmt.setString(3, a.getComentarioMedico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,new Date(a.getData().getTime()));
//		stmt.setList(7, a.getDoenca());
		
		stmt.execute();
	}
	
	public void update(Atendimento a) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();	
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Atendimento SET (?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(2, a.getComentarioEnfermeiro()); 
		stmt.setString(3, a.getComentarioMedico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,new Date(a.getData().getTime()));
	//	stmt.setList(7, a.getDoenca());
		
		stmt.execute();
	}
	
	public void select(Atendimento a) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT from Atendimento (?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(2, a.getComentarioEnfermeiro()); 
		stmt.setString(3, a.getComentarioMedico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,new Date(a.getData().getTime()));
	//	stmt.setList(7, a.getDoenca());
		
		//executa
		stmt.execute();
	}
}
