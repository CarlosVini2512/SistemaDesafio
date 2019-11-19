package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Atendimento;

public class AtendimentoDAO {

	public void save(Atendimento a) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "INSERT INTO Atendimento VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		//seta valores
		stmt.setInt(1, a.getIdAtendimento());
		stmt.setString(2, a.getComentarioEnfermeiro()); 
		stmt.setString(3, a.getComentarioMedico());
		stmt.setFloat(4, a.getAltura());
		stmt.setFloat(5, a.getPeso());
		stmt.setDate(6, java.sql.Date.valueOf(a.getData()));
		stmt.setString(7, a.getDoenca());
		//executa
		stmt.execute();
	}
	

	public void removeById(int idAtendimento) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();		
		System.out.println(conn.getStatus());		
		String sqlINSERE = "DELETE FROM Atendimento WHERE idAtendimento = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setInt(1,idAtendimento);
		stmt.execute();
	}
	
	public void update(Atendimento a) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();	
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Atendimento SET comentarioEnfermeiro=(?),comentarioMedico =(?),altura=(?),peso=(?)"
				+ "dData=(?),doenca=(?) where idAtendimento = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setString(1, a.getComentarioEnfermeiro()); 
		stmt.setString(2, a.getComentarioMedico());
		stmt.setFloat(3, a.getAltura());
		stmt.setFloat(4, a.getPeso());
		stmt.setDate(5,java.sql.Date.valueOf(a.getData()));
		stmt.setString(6, a.getDoenca());	
		stmt.setInt(7, a.getIdAtendimento());
		stmt.execute();
	}
	
	public List<Atendimento> select() {
		List <Atendimento> atendimento = new ArrayList<Atendimento>();
		try {
			
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();		
			System.out.println(conn.getStatus());
			String sqlINSERE = "SELECT * FROM Atendimento";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) {
				Atendimento atend = new Atendimento();
				atend.setComentarioEnfermeiro(rs.getString("comentarioEnfermeiro"));
				atend.setComentarioMedico(rs.getString("comentarioMedico"));
				atend.setAltura(rs.getFloat("altura"));
				atend.setPeso(rs.getFloat("peso"));
				atend.setData(rs.getDate("data").toLocalDate());
				atend.setDoenca(rs.getString("doenca"));
				atendimento.add(atend);
			}	
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return atendimento;
	}
	
}
