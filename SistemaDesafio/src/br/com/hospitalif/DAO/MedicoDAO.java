package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Medico;


public class MedicoDAO {

		public static void save(Medico m) throws SQLException {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			
			String sqlINSERE = "INSERT INTO Medico VALUES(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		    stmt.setInt(1, m.getIdMedico());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getCPF()); 
			stmt.setInt(4, m.getIdade()); 
			stmt.setString(5, m.getTipoSangue()); 
			stmt.setString(6, m.getSexo());
			stmt.setString(7, m.getLogin());
			stmt.setString(8, m.getSenha()); 		
			stmt.setString(9, m.getEspecialidade());
			stmt.setInt(10, m.getNumeroRegistro()); 
			stmt.execute();
		}
		
		public void removeById(int IdMedico)  throws SQLException{
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());		
			String sqlINSERE = "DELETE FROM Medico WHERE IdMedico = (?)";
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);		 
			stmt.setInt(1,IdMedico);
			stmt.execute();
		}
		
		public void update(Medico m) throws SQLException {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlINSERE = "UPDATE Medico SET nome=(?),cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?),statusPessoa=(?),"
					+ "login=(?),senha=(?),statusUsuario=(?),numeroRegistro=(?),especialidade=(?) WHERE idMedico=(?) where IdMedico = (?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		    stmt.setInt(1, m.getIdFuncionario());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getCPF()); 
			stmt.setInt(4, m.getIdade()); 
			stmt.setString(5, m.getTipoSangue()); 
			stmt.setString(6, m.getSexo());
			stmt.setString(7, m.getLogin());
			stmt.setString(8, m.getSenha()); 
			stmt.setString(9, m.getEspecialidade());
			stmt.setInt(10, m.getNumeroRegistro()); 
			
			
			stmt.execute();
		}
		
		public List<Medico> select() {
			List<Medico> listmedicos = new ArrayList<Medico>();
			try {
					Conexao conn = new Conexao();
					Connection conexao = conn.getConnection();
					System.out.println(conn.getStatus());
					String sqlINSERE = "SELECT * FROM Medico";
					PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			
					ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					Medico med = new Medico();
					med.setEspecialidade(rs.getString("especialidade"));
					med.setNumeroRegistro(rs.getInt("numeroderegistro"));
					med.setNome(rs.getString("nome"));
					med.setCPF(rs.getString("cpf"));
					med.setIdade(rs.getInt("idade"));
					med.setTipoSangue(rs.getString("tipoSanguineo"));
					med.setSexo(rs.getString("sexo"));
					med.setLogin(rs.getString("login"));
					med.setSenha(rs.getString("senha"));
				
					listmedicos.add(med);
			}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			return listmedicos;
			
		}
}
