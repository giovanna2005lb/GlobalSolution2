package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

public class EnderecoBO {
	
	EnderecoDAO enderecoDao;
	
	// Selecionar 
	public ArrayList<Endereco> selecionarBo () throws ClassNotFoundException, SQLException{
		enderecoDao = new EnderecoDAO();
		
		return (ArrayList<Endereco>) enderecoDao.selecionar();
	}
	
	// Inserir 
	public void inserirBo(Endereco endereco) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		enderecoDAO.inserir(endereco);
	}
	
	// Atualizar 
	public void atualizarBo(Endereco endereco) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		enderecoDAO.atualizar(endereco);
	}
	
	// Deletar 
	public void deletarBo(int id_endereco) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		enderecoDAO.deletar(id_endereco);	
	}


}
