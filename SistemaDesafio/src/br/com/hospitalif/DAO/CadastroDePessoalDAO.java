package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Pessoa;

public class CadastroDePessoalDAO {

	public void save(Pessoa cp) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO CadastroDePessoal VALUES(?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, cp.getNome());
		stmt.setString(2, cp.getCPF()); 
		stmt.setInt(3, cp.getIdade()); 
		stmt.setString(4, cp.getTipoSangue()); 
		stmt.setChar(5, cp.getSexo());
		stmt.setString(6, cp.getStatusDaPessoa());
		stmt.execute();
	}
	
	public void removeById(int id) {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM CadastroDePessoal" + "WHERE id = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, cp.getNome());
		stmt.setString(3, cp.getCPF()); 
		stmt.setInt(4, cp.getIdade()); 
		stmt.setString(5, cp.getTipoSangue()); 
		stmt.setChar(6, cp.getSexo());
		stmt.setString(7, cp.getStatusDaPessoa());
		stmt.execute();
	}
}