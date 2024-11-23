package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.ConsumoEnergetico;
import br.com.fiap.dao.ConsumoEnergeticoDAO;

public class ConsumoEnergeticoBO {

    private ConsumoEnergeticoDAO consumoDao;

    // Inserir
    public void inserirBo(ConsumoEnergetico consumoEnergetico) throws ClassNotFoundException, SQLException {
        consumoDao = new ConsumoEnergeticoDAO();
        consumoDao.inserir(consumoEnergetico);
    }

    // Atualizar
    public void atualizarBo(ConsumoEnergetico consumoEnergetico) throws ClassNotFoundException, SQLException {
        consumoDao = new ConsumoEnergeticoDAO();
        consumoDao.atualizar(consumoEnergetico);
    }

    // Deletar
    public void deletarBo(int idConsumo) throws ClassNotFoundException, SQLException {
        consumoDao = new ConsumoEnergeticoDAO();
        consumoDao.deletar(idConsumo);
    }

    // Selecionar
    public List<ConsumoEnergetico> selecionarBo() throws ClassNotFoundException, SQLException {
        consumoDao = new ConsumoEnergeticoDAO();
        return consumoDao.selecionar();
    }
}
