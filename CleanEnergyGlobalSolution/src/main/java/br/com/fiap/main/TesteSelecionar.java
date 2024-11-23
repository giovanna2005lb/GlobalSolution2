package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class TesteSelecionar {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Instanciar objetos 
		UsuarioDAO dao = new UsuarioDAO();
		
		List<Usuario> listaUsuario = (ArrayList<Usuario>) dao.selecionar();
		
		if(listaUsuario != null) {
			// foreach 
			for( Usuario usuario : listaUsuario) {
				System.out.println("Nome: " + usuario.getNome() + "\n" + 
									"Idade: " + usuario.getIdade() + "\n" + 
						        	"Email: " + usuario.getEmail() + "\n" + 
									"Preferencias Energeticas: " + usuario.getPreferenciasEnergeticas() + "\n" +
									"Tipo residencial: " + usuario.getTipoResidencial() + "\n"
						);
			}
		}

	}

}
