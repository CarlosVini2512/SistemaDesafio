package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Gerente;

public class GerenteDAO {

	public void save(Gerente g) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "INSERT INTO Gerente VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
	    stmt.setInt(1, g.getIdGerente());
		stmt.setString(2, g.getCargo());
		stmt.execute();
	}
	
	public void removeById(int IdGerente) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "DELETE FROM Gerente WHERE IdGerente = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setInt(1,IdGerente);	
		stmt.execute();
	}
	
	public void update(Gerente g) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "UPDATE Gerente SET(?,?) where IdGerente = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
	    stmt.setInt(1, g.getIdGerente());
		stmt.setString(2, g.getCargo());
		stmt.execute();
	}
	
	public void select(Gerente g) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "SELECT * FROM Gerente";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		ResultSet rs = stmt.executeQuery();
		List <Gerente> gerentes = new ArrayList<Gerente>();
		
		while(rs.next()) {
			Gerente ger = new Gerente();
			
			ger.setCargo(rs.getString("cargo"));
			gerentes.add(ger);
		}
	}
}
