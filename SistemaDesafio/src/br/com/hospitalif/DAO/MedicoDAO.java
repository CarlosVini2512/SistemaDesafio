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
			
			String sqlINSERE = "INSERT INTO Medico VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			stmt.setString(1, m.getEspecialidade());
			stmt.setInt(2, m.getNumeroRegistro()); 
			stmt.setString(3, m.getNome());
			stmt.setString(4, m.getCPF()); 
			stmt.setInt(5, m.getIdade()); 
			stmt.setString(6, m.getTipoSangue()); 
			stmt.setString(7, m.getSexo());
			stmt.setString(8, m.getStatusDaPessoa());
			stmt.setString(9, m.getLogin());
			stmt.setString(10, m.getSenha()); 
			stmt.setString(11, m.getStatusUsuario());
			
			stmt.execute();
		}
		
		public void removeById(int id)  throws SQLException{
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());		
			String sqlINSERE = "DELETE FROM Medico" + "WHERE id = (?)";
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);		 
			stmt.setInt(1,id);
			stmt.execute();
		}
		
		public void update(Medico m) throws SQLException {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlINSERE = "UPDATE Medico SET(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			
			stmt.setString(1, m.getEspecialidade());
			stmt.setInt(2, m.getNumeroRegistro()); 
			stmt.setString(3, m.getNome());
			stmt.setString(4, m.getCPF()); 
			stmt.setInt(5, m.getIdade()); 
			stmt.setString(6, m.getTipoSangue()); 
			stmt.setString(7, m.getSexo());
			stmt.setString(8, m.getStatusDaPessoa());
			stmt.setString(9, m.getLogin());
			stmt.setString(10, m.getSenha()); 
			stmt.setString(11, m.getStatusUsuario());
			
			stmt.execute();
		}
		
		public void select(Medico m) throws SQLException {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlINSERE = "SELECT * FROM Medico";
			PreparedStatement stmt = conexao.prepareStatement(sqlINSERE);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Medico> medicos = new ArrayList<Medico>();
			
			while(rs.next()) {
				Medico med = new Medico();
				med.setEspecialidade(rs.getString("especialidade"));
				med.setNumeroRegistro(rs.getInt("numeroderegistro"));
				med.setNome(rs.getString("nome"));
				med.setCPF(rs.getString("cpf"));
				med.setIdade(rs.getInt("idade"));
				med.setTipoSangue(rs.getString("tipoSanguineo"));
				med.setSexo(rs.getString("sexo"));
				med.setStatusDaPessoa(rs.getString("statusPessoa"));
				med.setLogin(rs.getString("login"));
				med.setSenha(rs.getString("senha"));
				med.setStatusUsuario(rs.getString("statusDeUsuario"));
				
				medicos.add(med);
			}
			
		}
}
