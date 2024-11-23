package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Sensor;
import br.com.fiap.dao.SensorDAO;

public class SensorBO {
	
	SensorDAO sensorDao;
	
	// Selecionar 
	public ArrayList<Sensor> selecionarBo () throws ClassNotFoundException, SQLException{
		sensorDao = new SensorDAO();
		
		return (ArrayList<Sensor>) sensorDao.selecionar();
	}
	
	// Inserir 
	public void inserirBo(Sensor sensor) throws ClassNotFoundException, SQLException {
		SensorDAO sensorDAO = new SensorDAO();
		
		sensorDAO.inserir(sensor);
	}
	
	// Atualizar 
	public void atualizarBo(Sensor sensor) throws ClassNotFoundException, SQLException {
		SensorDAO sensorDAO = new SensorDAO();
		
		sensorDAO.atualizar(sensor);
	}
	
	// Deletar 
	public void deletarBo(int id_sensor) throws ClassNotFoundException, SQLException {
		SensorDAO sensorDAO = new SensorDAO();
		
		sensorDAO.deletar(id_sensor);	
	}

}
