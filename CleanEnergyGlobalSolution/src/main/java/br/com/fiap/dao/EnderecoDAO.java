package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexoes.ConexaoFactory;

public class EnderecoDAO {
	
	public Connection minhaConexao;
	
	public EnderecoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	//Inserir
	
	public String inserir (Endereco endereco) throws SQLException{
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Insert into CleanEnergy_Endereco values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, endereco.getLogradouro());
		stmt.setInt(2, endereco.getNumero());
		stmt.setString(3, endereco.getCep());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setString(7, endereco.getComplemento());
		stmt.setInt(8, endereco.getId_endereco());
		stmt.setString(9, endereco.getUsuario().getEmail());
		stmt.execute();
		stmt.close();	
		
		return "Endereço cadastrado!";
	}
	// Deletar
	public String deletar(int id_endereco) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from CleanEnergy_Endereco where id_endereco = ?");
			stmt.setInt(1, id_endereco);
			stmt.execute();
			stmt.close();		
		return "Dispositivo deletado com Sucesso!";
	}
	// Atualizar 
	public String atualizar(Endereco endereco) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Update CleanEnergy_Endereco set LOGRADOURO = ?, NUMERO = ?, "
						+ "  CEP = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?" +
						"COMPLEMENTO = ? where ID_DISPOSITIVO = ?");
				stmt.setString(1, endereco.getLogradouro());
				stmt.setInt(2, endereco.getNumero());
				stmt.setString(3, endereco.getCep());
				stmt.setString(4, endereco.getBairro());
				stmt.setString(5, endereco.getCidade());
				stmt.setString(6, endereco.getEstado());
				stmt.setString(7, endereco.getComplemento());
				stmt.setInt(8, endereco.getId_endereco());
				stmt.executeUpdate();
				stmt.close();	
		return "Endereço atualizado com Sucesso!";
	}
	//Selecionar
	public List<Endereco> selecionar() throws SQLException{
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_Endereco");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setLogradouro(rs.getString(1));
				endereco.setNumero(rs.getInt(2));
				endereco.setCep(rs.getString(3));
				endereco.setBairro(rs.getString(4));
				endereco.setCidade(rs.getString(5));
				endereco.setEstado(rs.getString(6));
				endereco.setComplemento(rs.getString(7));
				endereco.setId_endereco(rs.getInt(8));
				endereco.getUsuario().setEmail(rs.getString(9));
				listaEndereco.add(endereco);
			}		
		return listaEndereco;		
	}

}
