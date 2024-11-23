package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class TesteDeletar {
	
	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos 
		Usuario objUsuario = new Usuario();
		
		UsuarioDAO dao = new UsuarioDAO();
		
		objUsuario.setEmail(texto("Digite o email do usuario a ser deletado"));
		
		System.out.println(dao.deletar(objUsuario.getEmail()));

	}

}
