package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Pessoa;

public class PessoaDAO {

	public static void save(Pessoa p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Pessoa VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
	    stmt.setInt(1, p.getIdPessoa());
		stmt.setString(4, p.getNome());
		stmt.setString(5, p.getCPF()); 
		stmt.setInt(6, p.getIdade()); 
		stmt.setString(7, p.getTipoSangue()); 
		stmt.setString(8, p.getSexo());
		stmt.setString(9, p.getStatusDaPessoa());
		
		stmt.execute();
	}
	
	public void removeById(int IdPessoa)  throws SQLException{
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());		
		String sqlINSERE = "DELETE FROM Pessoa WHERE IdPessoa = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);		 
		stmt.setInt(1,IdPessoa);
		stmt.execute();
	}
	
	public void update(Pessoa p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "UPDATE Pessoa SET(?,?,?,?,?,?,?) where IdPessoa = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1, p.getIdPessoa());
		stmt.setString(4, p.getNome());
		stmt.setString(5, p.getCPF()); 
		stmt.setInt(6, p.getIdade()); 
		stmt.setString(7, p.getTipoSangue()); 
		stmt.setString(8, p.getSexo());
		stmt.setString(9, p.getStatusDaPessoa());
		
		stmt.execute();
	}
	
	public void select(Pessoa p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "SELECT * FROM Pessoa";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		ResultSet rs = stmt.executeQuery();
		
		List<Pessoa> pessoa = new ArrayList<Pessoa>();
		
		while(rs.next()) {
			Pessoa pes = new Pessoa();
			stmt.setString(4, p.getNome());
			stmt.setString(5, p.getCPF()); 
			stmt.setInt(6, p.getIdade()); 
			stmt.setString(7, p.getTipoSangue()); 
			stmt.setString(8, p.getSexo());
			stmt.setString(9, p.getStatusDaPessoa());
			
			pessoa.add(pes);
		}
		
	}
}
