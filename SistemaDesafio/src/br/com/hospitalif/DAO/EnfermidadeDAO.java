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
		
		String sqlINSERE = "INSERT INTO Enfermidade VALUES(?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setInt(1, enf.getIdEnfermidade());
		stmt.setString(2, enf.getNome());
		stmt.setString(3, enf.getDescricao()); 
		stmt.setString(4, enf.getTipo()); 
		stmt.execute();
	}
	
	public void removeById(int IdEnfermidade) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Enfermidade WHERE IdEnfermidade = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1,IdEnfermidade);
		stmt.execute();
	}
	
	public void upadte(Enfermidade enf) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE FROM Enfermidade SET nome=(?),descricao=(?),tipo=(?)  where IdEnfermidade = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, enf.getNome());
		stmt.setString(2, enf.getDescricao());
		stmt.setString(3, enf.getTipo()); 
		stmt.setInt(4, enf.getIdEnfermidade());

		stmt.execute();
	}
	
	public List<Enfermidade> select() {
		List<Enfermidade> enfermidades = new ArrayList<Enfermidade>();
		try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			
			String sqlINSERE = "SELECT * FROM Enfermidade";	
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Enfermidade enf1 = new Enfermidade();
				enf1.setNome(rs.getString("nome"));
				enf1.setDescricao(rs.getString("descricao")); 
				enf1.setTipo(rs.getString("tipo")); 
				enfermidades.add(enf1);
			}	
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return enfermidades;
	}
}
