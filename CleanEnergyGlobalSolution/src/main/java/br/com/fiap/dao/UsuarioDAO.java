package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;
public class UsuarioDAO {
	
	public Connection minhaConexao;
	
	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Inserir 
	public String inserir (Usuario usuario) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Insert into CleanEnergy_Usuario values (?, ?, ?, ?, ?)");
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getIdade());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getTipoResidencial());
			stmt.setString(5, usuario.getPreferenciasEnergeticas());
			stmt.execute();
			stmt.close();			
		return "Cadastrado com Sucesso!";
	}
	
	// Deletar
	public String deletar(String email) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from CleanEnergy_Usuario where email = ?");
			stmt.setString(1, email);
			stmt.execute();
			stmt.close();		
		return "Deletado com Sucesso!";
	}
	// Atualizar 
	public String atualizar(Usuario usuario) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Update CleanEnergy_Usuario set NOME = ?, IDADE = ?, "
						+ "  TIPORESIDENCIAL = ?, PREFERENCIASENERGETICAS = ? where EMAIL = ?");
				stmt.setString(1, usuario.getNome());
				stmt.setInt(2, usuario.getIdade());
				stmt.setString(3, usuario.getTipoResidencial());
				stmt.setString(4, usuario.getPreferenciasEnergeticas());
				stmt.setString(5, usuario.getEmail());
				stmt.executeUpdate();
				stmt.close();	
		return "Atualizado com Sucesso!";
	}
	// Selecionar 
	public List<Usuario> selecionar() throws SQLException{
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_Usuario");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString(1));
				usuario.setIdade(rs.getInt(2));;
				usuario.setEmail(rs.getString(3));
				usuario.setTipoResidencial(rs.getString(4));
				usuario.setPreferenciasEnergeticas(rs.getString(5));
				listaUsuario.add(usuario);
			}		
		return listaUsuario;		
	}
	

}
