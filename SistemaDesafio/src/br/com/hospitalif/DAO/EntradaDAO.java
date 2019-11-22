package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Entrada;

public class EntradaDAO {

	public void save(Entrada ent) throws SQLException {
		try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
		
			String sqlINSERE = "INSERT INTO Entrada VALUES(?,?,?,?,?)";
		
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			stmt.setInt(1, ent.getIdEntrada());
			stmt.setDate(2, java.sql.Date.valueOf(ent.getDataEntrada()));
			stmt.setDate(3, java.sql.Date.valueOf(ent.getDataSaida()));
			stmt.setString(4, ent.getStatusEntrada());
			stmt.setString(5, ent.getSituacaoDoPaciente());
			stmt.execute();
		} catch (NullPointerException e) {
		}
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
		
		String sqlINSERE = "UPDATE Entrada SET dataEntrada=(?),dataSaida=(?),statusEntrada=(?),situacaoPaciente=(?) where IdEntrada = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setDate(1,java.sql.Date.valueOf(ent.getDataEntrada()));
		stmt.setDate(2,java.sql.Date.valueOf(ent.getDataSaida()));
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setString(4, ent.getSituacaoDoPaciente());
	    stmt.setInt(5, ent.getIdEntrada());
		stmt.execute();
	}	
	
	public List<Entrada> select() {
		List <Entrada> entradas = new ArrayList<Entrada>();
		try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
		
			String sqlINSERE = "SELECT * FROM Entrada";
		
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Entrada ent1 = new Entrada();
				ent1.setDataEntrada(rs.getDate("dataEntrada").toLocalDate());
				ent1.setDataSaida(rs.getDate("dataSaida").toLocalDate());
				ent1.setStatusEntrada("statusEntrada");
				ent1.setSituacaoDoPaciente("situacaoPaciente");
				entradas.add(ent1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return entradas;
	}	
}
