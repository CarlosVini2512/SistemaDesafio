package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Paciente;

public class PacienteDAO {

	public void save(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "INSERT INTO Paciente VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, p.getDoenca());
		stmt.setString(2, p.getHistorico()); 
		stmt.execute();
	}
	
	public void removeById(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();	
		System.out.println(conn.getStatus());	
		String sqlINSERE = "DELETE FROM Paciente" + "WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1,id);	
		stmt.execute();
	}
	
	public void upadte(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Paciente SET(?,?) where id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, p.getDoenca());
		stmt.setString(2, p.getHistorico()); 
		stmt.execute();
	}
	
	public void select(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT * FROM Paciente VALUES(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		ResultSet rs = stmt.executeQuery();
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		while(rs.next()) {
			Paciente p1 = new Paciente();
			p1.setDoenca(rs.getString("doenca"));
			p1.setHistorico(rs.getString("historico")); 
			pacientes.add(p1);
		}
	}
}
