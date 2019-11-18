package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Gerente;

public class GerenteDAO {

	public void save(Gerente g) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "INSERT INTO Gerente VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
	    stmt.setInt(1, g.getIdFuncionario());
	    stmt.setString(2, g.getNome());
		stmt.setInt(3, g.getCPF()); 
		stmt.setInt(4, g.getIdade()); 
		stmt.setString(5, g.getTipoSangue()); 
		stmt.setString(6, g.getSexo());
		stmt.setString(7, g.getStatusDaPessoa()); 
		stmt.setString(8, g.getLogin());
		stmt.setString(9, g.getSenha()); 		
		stmt.setString(10, g.getCargo());
		stmt.execute();
	}
	
	public void removeById(int IdGerente) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "DELETE FROM Gerente WHERE IdGerente = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setInt(1,IdGerente);	
		stmt.execute();
	}
	
	public void update(Gerente g) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "UPDATE Gerente SET nome = (?), cpf =(?), idade=(?),tipoSanguineo = (?), sexo = (?), status = (?), "
				+ "login = (?),senha = (?), cargo = (?) where IdGerente = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
	    stmt.setString(1, g.getNome());
		stmt.setInt(2, g.getCPF()); 
		stmt.setInt(3, g.getIdade()); 
		stmt.setString(4, g.getTipoSangue()); 
		stmt.setString(5, g.getSexo());
		stmt.setString(6, g.getLogin());
		stmt.setString(7, g.getSenha()); 		
		stmt.setString(8, g.getStatusDaPessoa()); 
		stmt.setString(9, g.getCargo());
	    stmt.setInt(10, g.getIdFuncionario());
		stmt.execute();
	}
	
	public List<Gerente> select() {
		List <Gerente> gerente = new ArrayList<Gerente>();
		try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlINSERE = "SELECT * FROM Gerente";
		
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) {
				Gerente ger = new Gerente();
			
				ger.setIdFuncionario(rs.getInt("id"));
				ger.setNome(rs.getString("nome"));
				ger.setCPF(rs.getInt("cpf"));
				ger.setIdade(rs.getInt("idade"));
				ger.setTipoSangue(rs.getString("tipoSanguineo"));
				ger.setSexo(rs.getString("sexo"));
				ger.setStatusDaPessoa(rs.getString("status"));
				ger.setLogin(rs.getString("login"));
				ger.setSenha(rs.getString("senha"));
				ger.setCargo(rs.getString("cargo"));
				gerente.add(ger);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return gerente;
	}
}
