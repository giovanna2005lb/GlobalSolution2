package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class TesteAtualizar {
	
	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static double real (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		Usuario objUsuario = new Usuario();
		
		UsuarioDAO dao = new UsuarioDAO();
		
		objUsuario.setEmail(texto("Insira o Email da conta que sofrerá atualização"));
		objUsuario.setNome(texto("Nome"));
		objUsuario.setIdade(inteiro("Idade"));
		objUsuario.setTipoResidencial(texto("Tipo Residencial"));
		objUsuario.setPreferenciasEnergeticas(texto("Preferencias Energéticas (DIA/NOITE)"));
		
		System.out.println(dao.atualizar(objUsuario));

		
	}

}
