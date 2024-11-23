package br.com.fiap.dao;

import br.com.fiap.beans.RelatorioEnergetico;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioEnergeticoDAO {

    private Connection minhaConexao;

    public RelatorioEnergeticoDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(RelatorioEnergetico relatorio) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO CleanEnergy_RelatorioEnergetico (idRelatorio, idUsuario, consumoTotal, custoTotal) VALUES (?, ?, ?, ?)"
        );
        stmt.setInt(1, relatorio.getIdRelatorio());
        stmt.setString(2, relatorio.getUsuario().getEmail());
        stmt.setDouble(3, relatorio.getConsumoTotal());
        stmt.setDouble(4, relatorio.getCustoTotal());
        stmt.execute();
        stmt.close();
        return "Relatório cadastrado com sucesso!";
    }

    // Deletar
    public String deletar(int idRelatorio) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM CleanEnergy_RelatorioEnergetico WHERE idRelatorio = ?"
        );
        stmt.setInt(1, idRelatorio);
        stmt.execute();
        stmt.close();
        return "Relatório deletado com sucesso!";
    }

    // Atualizar
    public String atualizar(RelatorioEnergetico relatorio) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE CleanEnergy_RelatorioEnergetico SET consumoTotal = ?, custoTotal = ? WHERE idRelatorio = ?"
        );
        stmt.setDouble(1, relatorio.getConsumoTotal());
        stmt.setDouble(2, relatorio.getCustoTotal());
        stmt.setInt(3, relatorio.getIdRelatorio());
        stmt.executeUpdate();
        stmt.close();
        return "Relatório atualizado com sucesso!";
    }

    // Selecionar
	public List<RelatorioEnergetico> selecionar() throws SQLException{
		List<RelatorioEnergetico> listaRelatorioEnergetico = new ArrayList<RelatorioEnergetico>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_RelatorioEnergetico");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				RelatorioEnergetico relatorio = new RelatorioEnergetico();
				relatorio.setIdRelatorio(rs.getInt(1));
				relatorio.getUsuario().setEmail(rs.getString(2));
				relatorio.setConsumoTotal(rs.getDouble(3));
				relatorio.setCustoTotal(rs.getDouble(4));
				listaRelatorioEnergetico.add(relatorio);
			}		
		return listaRelatorioEnergetico;		
	}
}
