package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.Date;
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
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6, new Date(a.getData().getTime()));
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
		
		String sqlINSERE = "UPDATE Atendimento SET (?,?,?,?,?,?,?) where idAtendimento = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		stmt.setInt(1, a.getIdAtendimento());
		stmt.setString(2, a.getComentarioEnfermeiro()); 
		stmt.setString(3, a.getComentarioMedico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,new Date(a.getData().getTime()));
		stmt.setString(7, a.getDoenca());		
		stmt.execute();
	}
	
	public void select(Atendimento a) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();		
		System.out.println(conn.getStatus());
		String sqlINSERE = "SELECT * FROM Atendimento";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		
		ResultSet rs = stmt.executeQuery();
		List <Atendimento> atendimento = new ArrayList<Atendimento>();
		
		while(rs.next()) {
			Atendimento atend = new Atendimento();
			atend.setComentarioEnfermeiro(rs.getString("comentarioEnfermeiro"));
			atend.setComentarioMedico(rs.getString("comentarioMedico"));
			atend.setPeso(rs.getFloat("peso"));
			atend.setAltura(rs.getFloat("altura"));
			atend.setData(rs.getDate("data"));
			atend.setDoenca(rs.getString("doenca"));
			atendimento.add(atend);
			
			//executa
			stmt.execute();
		}	
	}
	
}
