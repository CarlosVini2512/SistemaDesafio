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
		String sqlINSERE = "INSERT INTO EnfermidadePessoal VALUES(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		    stmt.setInt(1, ep.getIdEnfermidadePessoal());
			stmt.setString(2, ep.getComentario());
			stmt.setString(3, ep.getStatusEnfermidade()); 
			stmt.execute();
	}
	
	public void removeById(int IdEnfermidadePessoal) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM EnfermidadePessoal WHERE IdEnfermidadePessoal = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			stmt.setInt(1,IdEnfermidadePessoal);	
			stmt.execute();
	}
	
	public void update(EnfermidadePessoal ep) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE EnfermidadePessoal SET comentario = (?),statusEnfermidade=(?) where IdEnfermidadePessoal = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
	        stmt.setInt(1, ep.getIdEnfermidadePessoal());
			stmt.setString(1, ep.getComentario());
			stmt.setString(2, ep.getStatusEnfermidade()); 
			stmt.execute();
	}
	
	public List<EnfermidadePessoal> select(){
		List<EnfermidadePessoal> enfermidadePessoal = new ArrayList<EnfermidadePessoal>();
		try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());	
			String sqlINSERE = "SELECT * FROM EnfermidadePessoal";
		
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				EnfermidadePessoal ep1 = new EnfermidadePessoal();
				ep1.setComentario(rs.getString("comentario"));
				ep1.setStatusEnfermidade(rs.getString("statusDeEnfermidade")); 
				enfermidadePessoal .add(ep1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return enfermidadePessoal;
	}	
}
