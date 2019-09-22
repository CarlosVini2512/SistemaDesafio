package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Entrada;

public class EntradaDAO {

	public void save(Entrada ent) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Entrada VALUES(?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setDate(1, ent.getDataEntrada());
		stmt.setDate(2, ent.getDataSaida()); 
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setList(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}
	
	public void removeById(int id) {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Entrada" + "WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setDate(1, ent.getDataEntrada());
		stmt.setDate(2, ent.getDataSaida()); 
		stmt.setString(3, ent.getStatusEntrada());
		stmt.setList(4, ent.getSituacaoDoPaciente());
		stmt.execute();
	}
}
