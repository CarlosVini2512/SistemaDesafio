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
			try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			
			String sqlINSERE = "INSERT INTO Medico VALUES(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
		    stmt.setInt(1, m.getIdFuncionario());
			stmt.setString(2, m.getNome());
			stmt.setInt(3, m.getCPF()); 
			stmt.setInt(4, m.getIdade()); 
			stmt.setString(5, m.getTipoSangue()); 
			stmt.setString(6, m.getSexo());
			stmt.setString(7, m.getLogin());
			stmt.setString(8, m.getSenha()); 		
			stmt.setInt(9, m.getNumeroRegistro()); 
			stmt.setString(10, m.getEspecialidade());
			stmt.execute();
			} catch(NullPointerException e) {
				System.out.println("Preencha o campo Vazio");
			}
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
			String sqlINSERE = "UPDATE Medico SET nome=(?),cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?)"
					+ "login=(?),senha=(?),numeroRegistro=(?),especialidade=(?) WHERE idMedico=(?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			stmt.setString(1, m.getNome());
			stmt.setInt(2, m.getCPF()); 
			stmt.setInt(3, m.getIdade()); 
			stmt.setString(4, m.getTipoSangue()); 
			stmt.setString(5, m.getSexo());
			stmt.setString(6, m.getLogin());
			stmt.setString(7, m.getSenha());
			stmt.setString(8, m.getEspecialidade());
			stmt.setInt(9, m.getNumeroRegistro()); 
		    stmt.setInt(10, m.getIdFuncionario());	
			
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
					med.setIdFuncionario(rs.getInt("idMedico"));
					med.setNome(rs.getString("nome"));
					med.setCPF(rs.getInt("cpf"));
					med.setIdade(rs.getInt("idade"));
					med.setTipoSangue(rs.getString("tipoSanguineo"));
					med.setSexo(rs.getString("sexo"));
					med.setLogin(rs.getString("login"));
					med.setSenha(rs.getString("senha"));
					med.setNumeroRegistro(rs.getInt("numeroRegistro"));
					med.setEspecialidade(rs.getString("especialidade"));
				
					listmedicos.add(med);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			return listmedicos;
			
		}
}
