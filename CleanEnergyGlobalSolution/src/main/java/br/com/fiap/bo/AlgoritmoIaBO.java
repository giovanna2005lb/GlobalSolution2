package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.AlgoritmoIa;
import br.com.fiap.dao.AlgoritmoIaDAO;

public class AlgoritmoIaBO {
	
	AlgoritmoIaDAO AlgoritmoIaDao;
	
	// Selecionar 
	public ArrayList<AlgoritmoIa> selecionarBo () throws ClassNotFoundException, SQLException{
		AlgoritmoIaDao = new AlgoritmoIaDAO();
		
		return (ArrayList<AlgoritmoIa>) AlgoritmoIaDao.selecionar();
	}
	
	// Inserir 
	public void inserirBo(AlgoritmoIa algoritmoIa) throws ClassNotFoundException, SQLException {
		AlgoritmoIaDAO algoritmoIaDAO = new AlgoritmoIaDAO();
		
		algoritmoIaDAO.inserir(algoritmoIa);
	}
	
	// Atualizar 
	public void atualizarBo(AlgoritmoIa algoritmoIa) throws ClassNotFoundException, SQLException {
		AlgoritmoIaDAO algoritmoIaDAO = new AlgoritmoIaDAO();
		
		algoritmoIaDAO.atualizar(algoritmoIa);
	}
	
	// Deletar 
	public void deletarBo(String nome) throws ClassNotFoundException, SQLException {
		AlgoritmoIaDAO algoritmoIaDAO = new AlgoritmoIaDAO();
		
		algoritmoIaDAO.deletar(nome);	
	}

}
