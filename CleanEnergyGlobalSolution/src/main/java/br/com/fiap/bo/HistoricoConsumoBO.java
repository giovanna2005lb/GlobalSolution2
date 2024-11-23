package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.HistoricoConsumo;
import br.com.fiap.dao.HistoricoConsumoDAO;

public class HistoricoConsumoBO {

    private HistoricoConsumoDAO historicoDao;

    // Selecionar
    public List<HistoricoConsumo> selecionarBo() throws ClassNotFoundException, SQLException {
        historicoDao = new HistoricoConsumoDAO();
        return historicoDao.selecionar();
    }

    // Inserir
    public void inserirBo(HistoricoConsumo historico) throws ClassNotFoundException, SQLException {
        historicoDao = new HistoricoConsumoDAO();
        historicoDao.inserir(historico);
    }

    // Atualizar
    public void atualizarBo(HistoricoConsumo historico) throws ClassNotFoundException, SQLException {
        historicoDao = new HistoricoConsumoDAO();
        historicoDao.atualizar(historico);
    }

    // Deletar
    public void deletarBo(int idHistorico) throws ClassNotFoundException, SQLException {
        historicoDao = new HistoricoConsumoDAO();
        historicoDao.deletar(idHistorico);
    }
}
