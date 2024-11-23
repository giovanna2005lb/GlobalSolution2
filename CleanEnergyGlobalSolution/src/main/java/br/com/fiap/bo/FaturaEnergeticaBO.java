package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.FaturaEnergetica;
import br.com.fiap.dao.FaturaEnergeticaDAO;

public class FaturaEnergeticaBO {

    private FaturaEnergeticaDAO faturaDao;

    // Selecionar
    public List<FaturaEnergetica> selecionarBo() throws ClassNotFoundException, SQLException {
        faturaDao = new FaturaEnergeticaDAO();
        return faturaDao.selecionar();
    }

    // Inserir
    public void inserirBo(FaturaEnergetica fatura) throws ClassNotFoundException, SQLException {
        faturaDao = new FaturaEnergeticaDAO();
        faturaDao.inserir(fatura);
    }

    // Atualizar
    public void atualizarBo(FaturaEnergetica fatura) throws ClassNotFoundException, SQLException {
        faturaDao = new FaturaEnergeticaDAO();
        faturaDao.atualizar(fatura);
    }

    // Deletar
    public void deletarBo(int idFatura) throws ClassNotFoundException, SQLException {
        faturaDao = new FaturaEnergeticaDAO();
        faturaDao.deletar(idFatura);
    }
}
