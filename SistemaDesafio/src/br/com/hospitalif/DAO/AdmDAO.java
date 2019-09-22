package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Medico;

public class AdmDAO {

	public void save(Medico m) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Adm VALUES(?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.preparedStatement(sqlINSERE);
		stmt.setString(1, m.getEspecialidade());
		stmt.setString(2, m.getNumRegistro()); 
		stmt.execute();
	}
	
	public void removeById(int id) {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Medico" + "WHERE id = (?)";
		
		PreparedStatement stmt = conexao.preparedStatement(sqlINSERE);
		stmt.setString(1, m.getEspecialidade());
		stmt.setString(2, m.NumRegistro()); 
		stmt.execute();
	}
	
}
