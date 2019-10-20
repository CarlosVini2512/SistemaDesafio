package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Entrada;

public class EntradaDAO {

	public void save(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Entrada VALUES(?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
	    stmt.setInt(1, ent.getIdEntrada());
		stmt.setDate(2, new Date(ent.getDataEntrada().getTime()));
		stmt.setDate(3, new Date(ent.getDataSaida().getTime()));
		stmt.setString(4, ent.getStatusEntrada());
		stmt.setString(5, ent.getSituacaoDoPaciente());
		stmt.execute();
	}	

	
	public void removeById(int IdEntrada) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "DELETE FROM Entrada WHERE IdEntrada = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1,IdEntrada);	
		stmt.execute();
	}
	
	public void update(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Entrada SET(?,?,?,?) where IdEntrada = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
	    stmt.setInt(1, ent.getIdEntrada());
		stmt.setDate(2, new Date(ent.getDataEntrada().getTime()));
		stmt.setDate(3, new Date(ent.getDataSaida().getTime()));
		stmt.setString(4, ent.getStatusEntrada());
		stmt.setString(5, ent.getSituacaoDoPaciente());
		stmt.execute();
	}	
	
	public void select(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT * FROM Entrada";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		ResultSet rs = stmt.executeQuery();
		List <Entrada> entradas = new ArrayList<Entrada>();
		while(rs.next()) {
			Entrada ent1 = new Entrada();
			ent1.setDataEntrada(rs.getDate("dataEntrada"));
			ent1.setDataSaida(rs.getDate("dataSaida"));
			ent1.setStatusEntrada("statusDeEntrada");
			ent1.setSituacaoDoPaciente("situacaoDoPaciente");
			entradas.add(ent1);
		}
	}	
}
