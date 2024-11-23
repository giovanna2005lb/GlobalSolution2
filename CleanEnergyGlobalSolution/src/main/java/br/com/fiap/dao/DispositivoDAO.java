package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Dispositivo;
import br.com.fiap.conexoes.ConexaoFactory;

public class DispositivoDAO {
	
	public Connection minhaConexao;
	
	public DispositivoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	//Inserir
	
	public String inserir (Dispositivo dispositivo) throws SQLException{
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Insert into CleanEnergy_Dispositivo values (?, ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, dispositivo.getId_dispositivo());
		stmt.setString(2, dispositivo.getTipo_dispositivo());
		stmt.setDouble(3, dispositivo.getConsumoEnergia());
		stmt.setString(4, dispositivo.getStatus());
		stmt.setDouble(5, dispositivo.getPotencia());
		stmt.setString(6, dispositivo.getLocalizacao_dispositivo());
		stmt.setInt(7, dispositivo.getEndereco().getId_endereco());
		stmt.execute();
		stmt.close();	
		
		return "Dispositivo cadastrado!";
	}
	// Deletar
	public String deletar(int id_dispositivo) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from CleanEnergy_Dispositivo where id_dispositivo = ?");
			stmt.setInt(1, id_dispositivo);
			stmt.execute();
			stmt.close();		
		return "Dispositivo deletado com Sucesso!";
	}
	// Atualizar 
	public String atualizar(Dispositivo dispositivo) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Update CleanEnergy_Dispositivo set TIPO_DISPOSITIVO = ?, CONSUMOENERGIA = ?, "
						+ "  STATUS = ?, POTENCIA = ?, LOCALIZACAO_DISPOSITIVO = ?," +
						"ID_ENDERECO = ? where ID_DISPOSITIVO = ?");
				stmt.setString(2, dispositivo.getTipo_dispositivo());
				stmt.setDouble(3, dispositivo.getConsumoEnergia());
				stmt.setString(4, dispositivo.getStatus());
				stmt.setDouble(5, dispositivo.getPotencia());
				stmt.setString(6, dispositivo.getLocalizacao_dispositivo());
				stmt.setInt(7, dispositivo.getEndereco().getId_endereco());
				stmt.setInt(1, dispositivo.getId_dispositivo());
				stmt.executeUpdate();
				stmt.close();	
		return "Atualizado com Sucesso!";
	}
	//Selecionar
	public List<Dispositivo> selecionar() throws SQLException{
		List<Dispositivo> listaDispositivo = new ArrayList<Dispositivo>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_Dispositivo");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Dispositivo dispositivo = new Dispositivo();
				dispositivo.setId_dispositivo(rs.getInt(1));
				dispositivo.setTipo_dispositivo(rs.getString(2));
				dispositivo.setConsumoEnergia(rs.getDouble(3));
				dispositivo.setStatus(rs.getString(4));
				dispositivo.setPotencia(rs.getDouble(5));
				dispositivo.setLocalizacao_dispositivo(rs.getString(6));
				dispositivo.getEndereco().setId_endereco(rs.getInt(7));;
				listaDispositivo.add(dispositivo);
			}		
		return listaDispositivo;		
	}
}
