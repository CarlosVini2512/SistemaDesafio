package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Enfermeiro;

public class EnfermeiroDAO {

	public void save(Enfermeiro e) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "INSERT INTO Enfermeiro VALUES(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1, e.getIdEnfermeiro());
		stmt.setString(2, e.getNome());
		stmt.setString(3, e.getCPF()); 
		stmt.setInt(4, e.getIdade()); 
		stmt.setString(5, e.getTipoSangue()); 
		stmt.setString(6, e.getSexo());
		stmt.setString(7, e.getLogin());
		stmt.setString(8, e.getSenha()); 
		stmt.setInt(9, e.getNumeroRegistro());
		stmt.execute();
	}
	
	public void removeById(int IdEnfermeiro) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();	
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "DELETE FROM Enfermeiro WHERE IdEnfermeiro = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setInt(1,IdEnfermeiro);
		stmt.execute();
	}
	
	public void update(Enfermeiro e) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Enfermeiro SET nome=(?), cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?),login=(?)"
				+ ",senha=(?),numeroRegistro=(?) where id=(?) ";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1, e.getIdEnfermeiro());
		stmt.setString(2, e.getNome());
		stmt.setString(3, e.getCPF()); 
		stmt.setInt(4, e.getIdade()); 
		stmt.setString(5, e.getTipoSangue()); 
		stmt.setString(6, e.getSexo());
		stmt.setString(7, e.getLogin());
		stmt.setString(8, e.getSenha()); 
		stmt.setInt(9, e.getNumeroRegistro());
		stmt.execute();
	}
	
	public List<Enfermeiro> select() {
		List <Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
		try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
		
			String sqlINSERE = "SELECT * FROM Enfermeiro";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) {
				Enfermeiro enf = new Enfermeiro();
				enf.setIdFuncionario(rs.getInt("id"));
				enf.setNome(rs.getString("nome"));
				enf.setCPF(rs.getString("cpf"));
				enf.setIdade(rs.getInt("idade"));
				enf.setTipoSangue(rs.getString("tipoSanguineo"));
				enf.setSexo(rs.getString("sexo"));
				enf.setLogin(rs.getString("login"));
				enf.setSenha(rs.getString("senha"));
				enf.setNumeroRegistro(rs.getInt("numeroDeRegistro"));
				enfermeiros.add(enf);
			}
		} catch (SQLException en) {
			// TODO: handle exception
		}
		return enfermeiros;
	}
	
}
