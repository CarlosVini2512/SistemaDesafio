package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Paciente;

public class PacienteDAO {

	public void save(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlINSERE = "INSERT INTO Paciente VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1, p.getIdPaciente());
		stmt.setString(2, p.getNome());
		stmt.setString(3, p.getCPF()); 
		stmt.setInt(4, p.getIdade()); 
		stmt.setString(5, p.getTipoSangue()); 
		stmt.setString(6, p.getSexo());
		stmt.setString(7, p.getDoenca());
		stmt.setString(8, p.getHistorico()); 
		stmt.execute();
	}
	
	public void removeById(int IdPaciente) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();	
		System.out.println(conn.getStatus());	
		String sqlINSERE = "DELETE FROM Paciente WHERE IdPaciente = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1,IdPaciente);	
		stmt.execute();
	}
	
	public void upadte(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		
		String sqlINSERE = "UPDATE Paciente SET nome = (?), cpf =(?), idade=(?), tipoSanguineo = (?), sexo = (?), "
				+ "doenca = (?), historico = (?) WHERE IdPaciente = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		stmt.setInt(1, p.getIdPaciente());
		stmt.setString(2, p.getNome());
		stmt.setString(3, p.getCPF()); 
		stmt.setInt(4, p.getIdade()); 
		stmt.setString(5, p.getTipoSangue()); 
		stmt.setString(6, p.getSexo());
		stmt.setString(7, p.getDoenca());
		stmt.setString(8, p.getHistorico()); 
		stmt.execute();
	}
	
	public List<Paciente> select() throws SQLException {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		try {	
				Conexao conn = new Conexao();
				Connection conexao = conn.getConnection();
				System.out.println(conn.getStatus());
		
				String sqlINSERE = "SELECT * FROM Paciente";
		
				PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
				ResultSet rs = stmt.executeQuery();
		
				while(rs.next()) {
					Paciente p1 = new Paciente();
					p1.setIdPaciente(rs.getInt("idPaciente"));
					p1.setNome(rs.getString("nome"));
					p1.setCPF(rs.getString("cpf"));
					p1.setIdade(rs.getInt("idade"));
					p1.setTipoSangue(rs.getString("tipoSanguineo"));
					p1.setSexo(rs.getString("sexo"));
					p1.setDoenca(rs.getString("doenca"));
					p1.setHistorico(rs.getString("historico")); 
					pacientes.add(p1);
				}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return pacientes;
	}
}
