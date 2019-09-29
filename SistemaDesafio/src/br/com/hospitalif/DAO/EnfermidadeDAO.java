package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Enfermidade;

public class EnfermidadeDAO {

	public void save(Enfermidade enf) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Enfermidade VALUES(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, enf.getNome());
		stmt.setString(3, enf.getTipo()); 
		stmt.setString(4, enf.getDescricao()); 
		stmt.execute();
	}
	
	public void removeById(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Enfermidade WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1,id);
		stmt.execute();
	}
	
	public void upadte(Enfermidade enf) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE FROM Enfermidade SET(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, enf.getNome());
		stmt.setString(3, enf.getTipo()); 
		stmt.setString(4, enf.getDescricao()); 
		stmt.execute();
	}
	
	public void select(Enfermidade enf) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT * FROM Enfermidade SET(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		ResultSet rs = stmt.executeQuery();
		List<Enfermidade> enfermidades = new ArrayList<Enfermidade>();
		while(rs.next()) {
			Enfermidade enf1 = new Enfermidade();
			enf1.setNome(rs.getString("nome"));
			enf1.setTipo(rs.getString("tipo")); 
			enf1.setDescricao(rs.getString("descricao")); 
			enfermidades.add(enf1);
		}
	}
}
