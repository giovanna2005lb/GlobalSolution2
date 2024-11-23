package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.ConsumoEnergetico;
import br.com.fiap.conexoes.ConexaoFactory;

public class ConsumoEnergeticoDAO {
	
	public Connection minhaConexao;
	
	public ConsumoEnergeticoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	//Inserir
	
	public String inserir (ConsumoEnergetico consumoEnergetico) throws SQLException{
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Insert into CleanEnergy_ConsumoEnergetico values (?, ?, ?, ?, ?)");
		stmt.setInt(1, consumoEnergetico.getIdConsumo());
		stmt.setDouble(2, consumoEnergetico.getConsumo());
		stmt.setDouble(3, consumoEnergetico.getCusto());
		stmt.setInt(4, consumoEnergetico.getDispositivo().getId_dispositivo());
		stmt.setTimestamp(5, new java.sql.Timestamp(consumoEnergetico.getDataHora().getTime()));
		stmt.execute();
		stmt.close();	
		
		return "Consumo cadastrado!";
	}
	// Deletar
	public String deletar(int idConsumo) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from CleanEnergy_ConsumoEnergetico where idConsumo = ?");
			stmt.setInt(1, idConsumo);
			stmt.execute();
			stmt.close();		
		return "Consumo deletado com Sucesso!";
	}
	// Atualizar 
	public String atualizar(ConsumoEnergetico consumoEnergetico) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Update CleanEnergy_ConsumoEnergetico set CONSUMO = ?, CUSTO = ?, "
						+ "  dataHora = ? where idConsumo = ?");
				stmt.setDouble(1, consumoEnergetico.getConsumo());
				stmt.setDouble(2, consumoEnergetico.getCusto());
				stmt.setTimestamp(3, new java.sql.Timestamp(consumoEnergetico.getDataHora().getTime()));
				stmt.setInt(4, consumoEnergetico.getIdConsumo());
				stmt.executeUpdate();
				stmt.close();	
		return "Consumo atualizado com Sucesso!";
	}
	//Selecionar
	public List<ConsumoEnergetico> selecionar() throws SQLException{
		List<ConsumoEnergetico> listaConsumoEnergetico = new ArrayList<ConsumoEnergetico>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_ConsumoEnergetico");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ConsumoEnergetico consumoEnergetico = new ConsumoEnergetico();
				consumoEnergetico.setIdConsumo(rs.getInt(1));
				consumoEnergetico.setConsumo(rs.getDouble(2));
				consumoEnergetico.setCusto(rs.getDouble(3));
				consumoEnergetico.getDispositivo().setId_dispositivo(4);
				consumoEnergetico.setDataHora(rs.getTimestamp(5));
				listaConsumoEnergetico.add(consumoEnergetico);
			}		
		return listaConsumoEnergetico;		
	}

}
