package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Funcionario;
import br.com.hospitalif.model.Pessoa;

public class FuncionarioDAO {

	public static void save(Funcionario f) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Funcionario VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
	    stmt.setInt(1, f.getIdPessoa());
		stmt.setString(2, f.getNome());
		stmt.setInt(3, f.getCPF()); 
		stmt.setInt(4, f.getIdade()); 
		stmt.setString(5, f.getTipoSangue()); 
		stmt.setString(6, f.getSexo());
		stmt.setString(7, f.getStatusDaPessoa());
		
		stmt.execute();
	}
	
	public void removeById(int idFuncionario)  throws SQLException{
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());		
		String sqlINSERE = "DELETE FROM Funcionario WHERE idFuncionario = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);		 
		stmt.setInt(1,idFuncionario);
		stmt.execute();
	}
	
	public void update(Funcionario f) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "UPDATE Funcionario SET nome=(?), cpf=(?), idade=(?), sangue=(?), sexo=(?)"
				+ " status=(?) where idFuncionario = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setString(1, f.getNome());
		stmt.setInt(2, f.getCPF()); 
		stmt.setInt(3, f.getIdade()); 
		stmt.setString(4, f.getTipoSangue()); 
		stmt.setString(5, f.getSexo());
		stmt.setString(6, f.getStatusDaPessoa());
		stmt.setInt(7, f.getIdFuncionario());
		
		stmt.execute();
	}
	
	public List<Funcionario> select() throws SQLException {
		List<Funcionario> selecao = new ArrayList<Funcionario>();
		try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlINSERE = "SELECT * FROM Funcionario";
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
			ResultSet rs = stmt.executeQuery();
				
		while(rs.next()) {
			Funcionario func = new Funcionario();
			func.setIdFuncionario(rs.getInt("idFuncionario"));
			func.setNome(rs.getString("nome"));
			func.setCPF(rs.getInt("cpf")); 
			func.setIdade(rs.getInt("idade")); 
			func.setTipoSangue(rs.getString("sangue")); 
			func.setSexo(rs.getString("sexo"));
			func.setStatusDaPessoa(rs.getString("status"));
			selecao.add(func);
		}}catch (SQLException e) {
			// TODO: handle exception
		}
		return selecao;
		
	}
}
