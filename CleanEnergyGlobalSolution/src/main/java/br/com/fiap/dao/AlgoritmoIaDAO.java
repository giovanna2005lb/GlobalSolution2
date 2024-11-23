package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.AlgoritmoIa;
import br.com.fiap.conexoes.ConexaoFactory;

public class AlgoritmoIaDAO {
	
	public Connection minhaConexao;
	
	public AlgoritmoIaDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Inserir 
	public String inserir (AlgoritmoIa algoritmoIa) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Insert into CleanEnergy_IA values (?, ?, ?, ?, ?)");
			stmt.setString(1, algoritmoIa.getNome());
			stmt.setString(2, algoritmoIa.getDescricao());
			stmt.setDouble(3, algoritmoIa.getEficiencia());
			stmt.setString(4, algoritmoIa.getTipoModelo());
			stmt.setString(5, algoritmoIa.getTreinado());
			stmt.execute();
			stmt.close();			
		return "IA Cadastrado com Sucesso!";
	}
	
	// Deletar
	public String deletar(String nome) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from CleanEnergy_IA where nome = ?");
			stmt.setString(1, nome);
			stmt.execute();
			stmt.close();		
		return "IA Deletado com Sucesso!";
	}
	// Atualizar 
	public String atualizar(AlgoritmoIa algoritmoIa) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Update CleanEnergy_IA set DESCRICAO = ?, EFICIENCIA = ?, "
						+ "  TIPOMODELO = ?, TREINADO = ? where NOME = ?");
				stmt.setString(2, algoritmoIa.getDescricao());
				stmt.setDouble(4, algoritmoIa.getEficiencia());
				stmt.setString(5, algoritmoIa.getTipoModelo());
				stmt.setString(3, algoritmoIa.getTreinado());
				stmt.setString(1, algoritmoIa.getNome());
				stmt.executeUpdate();
				stmt.close();	
		return "Atualizado com Sucesso!";
	}
	// Selecionar 
	public List<AlgoritmoIa> selecionar() throws SQLException{
		List<AlgoritmoIa> listaAlgoritmoIa = new ArrayList<AlgoritmoIa>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_IA");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				AlgoritmoIa algoritmoIa = new AlgoritmoIa();
				algoritmoIa.setNome(rs.getString(1));
				algoritmoIa.setDescricao(rs.getString(2));
				algoritmoIa.setEficiencia(rs.getDouble(3));
				algoritmoIa.setTipoModelo(rs.getString(4));
				algoritmoIa.setTreinado(rs.getString(5));
				listaAlgoritmoIa.add(algoritmoIa);
			}		
		return listaAlgoritmoIa;		
	}

}
