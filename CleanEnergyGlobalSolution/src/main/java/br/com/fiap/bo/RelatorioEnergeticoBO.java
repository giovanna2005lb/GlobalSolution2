package br.com.fiap.bo;

import br.com.fiap.beans.RelatorioEnergetico;
import br.com.fiap.dao.RelatorioEnergeticoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RelatorioEnergeticoBO {

    RelatorioEnergeticoDAO relatorioDao;

    // Selecionar
    public ArrayList<RelatorioEnergetico> selecionarBo() throws ClassNotFoundException, SQLException {
        relatorioDao = new RelatorioEnergeticoDAO();
        return (ArrayList<RelatorioEnergetico>) relatorioDao.selecionar();
    }

    // Inserir
    public void inserirBo(RelatorioEnergetico relatorio) throws ClassNotFoundException, SQLException {
        relatorioDao = new RelatorioEnergeticoDAO();
        relatorioDao.inserir(relatorio);
    }

    // Atualizar
    public void atualizarBo(RelatorioEnergetico relatorio) throws ClassNotFoundException, SQLException {
        relatorioDao = new RelatorioEnergeticoDAO();
        relatorioDao.atualizar(relatorio);
    }

    // Deletar
    public void deletarBo(int idRelatorio) throws ClassNotFoundException, SQLException {
        relatorioDao = new RelatorioEnergeticoDAO();
        relatorioDao.deletar(idRelatorio);
    }
}
