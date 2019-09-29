package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.EnfermidadePessoal;

public class EnfermidadePessoalDAO {

	public void save(EnfermidadePessoal ep) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "INSERT INTO EnfermidadePessoal VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			stmt.setString(1, ep.getComentario());
			stmt.setString(2, ep.getStatusEnfermidade()); 
			stmt.execute();
	}
	
	public void removeById(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM EnfermidadePessoal WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			stmt.setInt(1,id);	
			stmt.execute();
	}
	
	public void update(EnfermidadePessoal ep) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE EnfermidadePessoal SET(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			stmt.setString(1, ep.getComentario());
			stmt.setString(2, ep.getStatusEnfermidade()); 
			stmt.execute();
	}
	public void select(EnfermidadePessoal ep) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());	
		String sqlINSERE = "SELECT * FROM EnfermidadePessoal VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		ResultSet rs = stmt.executeQuery();
		List<EnfermidadePessoal> enfermidadesPessoais = new ArrayList<EnfermidadePessoal>();
		while(rs.next()) {
			EnfermidadePessoal ep1 = new EnfermidadePessoal();
			ep1.setComentario(rs.getString("comentario"));
			ep1.setStatusEnfermidade(rs.getString("statusDeEnfermidade")); 
			enfermidadesPessoais .add(ep1);
		}
	}
}
