package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.HistoricoConsumo;
import br.com.fiap.conexoes.ConexaoFactory;

public class HistoricoConsumoDAO {

    private Connection minhaConexao;

    public HistoricoConsumoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(HistoricoConsumo historico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
            "INSERT INTO CleanEnergy_HistoricoConsumo (idHistorico, email, idDispositivo, consumo, data) VALUES (?, ?, ?, ?, ?)");
        stmt.setInt(1, historico.getIdHistorico());
        stmt.setString(2, historico.getUsuario().getEmail());
        stmt.setInt(3, historico.getDispositivo().getId_dispositivo());
        stmt.setDouble(4, historico.getConsumo());
        stmt.setDate(5, new java.sql.Date(historico.getData().getTime()));
        stmt.execute();
        stmt.close();
        return "Histórico de consumo inserido com sucesso!";
    }

    // Atualizar
    public String atualizar(HistoricoConsumo historico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
            "UPDATE CleanEnergy_HistoricoConsumo SET email = ?, idDispositivo = ?, consumo = ?, data = ? WHERE idHistorico = ?");
        stmt.setString(1, historico.getUsuario().getEmail());
        stmt.setInt(2, historico.getDispositivo().getId_dispositivo());
        stmt.setDouble(3, historico.getConsumo());
        stmt.setDate(4, new java.sql.Date(historico.getData().getTime()));
        stmt.setInt(5, historico.getIdHistorico());
        stmt.executeUpdate();
        stmt.close();
        return "Histórico de consumo atualizado com sucesso!";
    }

    // Deletar
    public String deletar(int idHistorico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
            "DELETE FROM CleanEnergy_HistoricoConsumo WHERE idHistorico = ?");
        stmt.setInt(1, idHistorico);
        stmt.execute();
        stmt.close();
        return "Histórico de consumo deletado com sucesso!";
    }

    // Selecionar
	public List<HistoricoConsumo> selecionar() throws SQLException{
		List<HistoricoConsumo> listaHistoricoConsumo = new ArrayList<HistoricoConsumo>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM CleanEnergy_HistoricoConsumo");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				HistoricoConsumo historico = new HistoricoConsumo();
				historico.setIdHistorico(rs.getInt(1));
				historico.getUsuario().setEmail(rs.getString(2));
				historico.getDispositivo().setId_dispositivo(rs.getInt(3));
				historico.setConsumo(rs.getDouble(4));
				historico.setData(rs.getDate(5));
				listaHistoricoConsumo.add(historico);
			}		
		return listaHistoricoConsumo;		
	}
}
