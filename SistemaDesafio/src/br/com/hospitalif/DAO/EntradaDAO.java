package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Entrada;

public class EntradaDAO {

	public void save(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Entrada VALUES(?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setDate(1, new Date(ent.getDataEntrada().getTime()));
		stmt.setDate(2, new Date(ent.getDataSaida().getTime()));
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setList(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}	

	
	public void removeById(Entrada ent) {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Entrada" + "WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setDate(1, new Date(ent.getDataEntrada().getTime()));
		stmt.setDate(2, new Date(ent.getDataSaida().getTime()));
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setList(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}
	
	public void update(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Entrada SET(?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setDate(1, new Date(ent.getDataEntrada().getTime()));
		stmt.setDate(2, new Date(ent.getDataSaida().getTime()));
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setList(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}	
	
	public void select(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT Entrada VALUES(?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setDate(1, new Date(ent.getDataEntrada().getTime()));
		stmt.setDate(2, new Date(ent.getDataSaida().getTime()));
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setList(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}	
}
