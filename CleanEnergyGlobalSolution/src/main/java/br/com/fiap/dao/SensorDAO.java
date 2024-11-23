package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Sensor;
import br.com.fiap.conexoes.ConexaoFactory;

public class SensorDAO {
	
	public Connection minhaConexao;
	
	public SensorDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	//Inserir
	
		public String inserir (Sensor sensor) throws SQLException{
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Insert into CleanEnergy_Sensor values (?, ?, ?, ?, ?)");
			stmt.setInt(1, sensor.getId_sensor());
			stmt.setString(2,sensor.getTipo_sensor());
			stmt.setDouble(3,sensor.getValor());
			stmt.setString(4,sensor.getLocalizacao_sensor());
			stmt.setInt(5,sensor.getEndereco().getId_endereco());
			stmt.execute();
			stmt.close();	
			
			return "Sensor cadastrado!";
		}
		// Deletar
		public String deletar(int id_sensor) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from CleanEnergy_Sensor where id_endereco = ?");
				stmt.setInt(1, id_sensor);
				stmt.execute();
				stmt.close();		
			return "Sensor deletado com Sucesso!";
		}
		// Atualizar 
		public String atualizar(Sensor sensor) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update CleanEnergy_Sensor set TIPO_SENSOR = ?, VALOR = ?, "
							+ "  LOCALIZACAO_SENSOR = ?, ID_ENDERECO = ? where ID_SENSOR = ?");
					stmt.setString(2, sensor.getTipo_sensor());
					stmt.setDouble(3, sensor.getValor());
					stmt.setString(4, sensor.getLocalizacao_sensor());
					stmt.setDouble(5, sensor.getEndereco().getId_endereco());
					stmt.setInt(1, sensor.getId_sensor());
					stmt.executeUpdate();
					stmt.close();	
			return "Sensor atualizado com Sucesso!";
		}
		//Selecionar
		public List<Sensor> selecionar() throws SQLException{
			List<Sensor> listaSensor = new ArrayList<Sensor>();
			PreparedStatement stmt = minhaConexao.prepareStatement
					("SELECT * FROM CleanEnergy_Sensor");
			
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Sensor sensor = new Sensor();
					sensor.setId_sensor(rs.getInt(1));
					sensor.setTipo_sensor(rs.getString(2));
					sensor.setValor(rs.getInt(3));
					sensor.setLocalizacao_sensor(rs.getString(4));
					sensor.getEndereco().setId_endereco(rs.getInt(5));
					listaSensor.add(sensor);
				}		
			return listaSensor;		
		}

}
