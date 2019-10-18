package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Enfermeiro;

public class EnfermeiroDAO {

	public void save(Enfermeiro e) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Enfermeiro VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1, e.getIdFuncionario());
		stmt.setInt(2, e.getNumeroRegistro());
		stmt.execute();
	}
	
	public void removeById(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Enfermeiro WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setInt(1,id);
		stmt.execute();
	}
	
	public void update(Enfermeiro e) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Enfermeiro SET(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1, e.getIdFuncionario());
		stmt.setInt(1, e.getNumeroRegistro());
		stmt.execute();
	}
	
	public void select(Enfermeiro e) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT * FROM Enfermeiro VALUES(?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		ResultSet rs = stmt.executeQuery();
		List <Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
		
		while(rs.next()) {
		Enfermeiro enf = new Enfermeiro();
		enf.setNumeroRegistro(rs.getInt("numeroderegistro"));
		enfermeiros.add(enf);
		}
	}
	
}
