package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBO {
	
	UsuarioDAO usuarioDao;
	
	// Selecionar 
	public ArrayList<Usuario> selecionarBo () throws ClassNotFoundException, SQLException{
		usuarioDao = new UsuarioDAO();
		
		return (ArrayList<Usuario>) usuarioDao.selecionar();
	}
	
	// Inserir 
	public void inserirBo(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.inserir(usuario);
	}
	
	// Atualizar 
	public void atualizarBo(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.atualizar(usuario);
	}
	
	// Deletar 
	public void deletarBo(String email) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.deletar(email);	
	}

}
