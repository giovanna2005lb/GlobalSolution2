package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Dispositivo;
import br.com.fiap.dao.DispositivoDAO;

public class DispositivoBO {
	
	DispositivoDAO dispositivoDao;
	
	// Selecionar 
	public ArrayList<Dispositivo> selecionarBo () throws ClassNotFoundException, SQLException{
		dispositivoDao = new DispositivoDAO(); 
		
		return (ArrayList<Dispositivo>) dispositivoDao.selecionar();
	}
	
	// Inserir 
	public void inserirBo(Dispositivo dispositivo) throws ClassNotFoundException, SQLException {
		DispositivoDAO dispositivoDAO = new DispositivoDAO();
		
		dispositivoDAO.inserir(dispositivo);
	}
	
	// Atualizar 
	public void atualizarBo(Dispositivo dispositivo) throws ClassNotFoundException, SQLException {
		DispositivoDAO dispositivoDAO = new DispositivoDAO();
		
		dispositivoDAO.atualizar(dispositivo);
	}
	
	// Deletar 
	public void deletarBo(int id_dispositivo) throws ClassNotFoundException, SQLException {
		DispositivoDAO dispositivoDAO = new DispositivoDAO();
		
		dispositivoDAO.deletar(id_dispositivo);	
	}


}
