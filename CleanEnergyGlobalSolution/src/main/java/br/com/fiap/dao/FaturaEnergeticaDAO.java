package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.FaturaEnergetica;
import br.com.fiap.conexoes.ConexaoFactory;

public class FaturaEnergeticaDAO {

	
	public Connection minhaConexao;
	
	public FaturaEnergeticaDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Inserir 
	public String inserir (FaturaEnergetica faturaEnergetica) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Insert into CleanEnergy_FaturaEnergetica values (?, ?, ?, ?, ?, ?)");
			stmt.setDouble(1, faturaEnergetica.getIdFatura());
			stmt.setString(2, faturaEnergetica.getUsuario().getEmail());
			stmt.setDouble(3, faturaEnergetica.getTotalConsumo());
			stmt.setDouble(4, faturaEnergetica.getValorFatura());
			stmt.setDate(5, new Date(faturaEnergetica.getPeriodoInicio().getTime()));
			stmt.setDate(6, new Date(faturaEnergetica.getPeriodoFim().getTime()));
			stmt.execute();
			stmt.close();			
		return "Fatura cadastrada com Sucesso!";
	}
	
	// Deletar
	public String deletar(int idFatura) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from CleanEnergy_FaturaEnergetica where idFatura = ?");
			stmt.setInt(1, idFatura);
			stmt.execute();
			stmt.close();		
		return "Fatura deletada com Sucesso!";
	}
	// Atualizar 
	public String atualizar(FaturaEnergetica faturaEnergetica) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Update CleanEnergy_FaturaEnergetica set TOTALCONSUMO = ?, VALORFATURA = ?, "
						+ "  PERIODOINICIO = ?, PERIODOFIM = ? where IDFATURA = ?");
				stmt.setDouble(1, faturaEnergetica.getTotalConsumo());
				stmt.setDouble(2, faturaEnergetica.getValorFatura());
				stmt.setDate(3, new Date (faturaEnergetica.getPeriodoInicio().getTime()));
				stmt.setDate(4, new Date (faturaEnergetica.getPeriodoFim().getTime()));
				stmt.setDouble(5, faturaEnergetica.getIdFatura());
				stmt.executeUpdate();
				stmt.close();	
		return "Atualizado com Sucesso!";
	}
	// Selecionar 
	public List<FaturaEnergetica> selecionar() throws SQLException{
		List<FaturaEnergetica> listaFaturaEnergetica = new ArrayList<FaturaEnergetica>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_FaturaEnergetica");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				FaturaEnergetica faturaEnergetica = new FaturaEnergetica();
				faturaEnergetica.setIdFatura(rs.getInt(1));
				faturaEnergetica.getUsuario().setEmail(rs.getString(2));
				faturaEnergetica.setTotalConsumo(rs.getDouble(3));
				faturaEnergetica.setValorFatura(rs.getDouble(4));
				faturaEnergetica.setPeriodoInicio(rs.getDate(5));
				faturaEnergetica.setPeriodoFim(rs.getDate(6));
				listaFaturaEnergetica.add(faturaEnergetica);
			}		
		return listaFaturaEnergetica;		
	}
}
