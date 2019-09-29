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
		stmt.setDate(1, new Date(ent.getDataEntrada().getTime()));
		stmt.setDate(2, new Date(ent.getDataSaida().getTime()));
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setString(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}	

	
	public void removeById(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "DELETE FROM Entrada WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1,id);	
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
		stmt.setString(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}	
	
	public void select(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "SELECT * FROM Entrada VALUES(?,?,?,?)";
		
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
