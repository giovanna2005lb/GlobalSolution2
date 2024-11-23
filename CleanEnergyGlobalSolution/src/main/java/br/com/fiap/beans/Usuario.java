package br.com.fiap.beans;

public class Usuario {
	private String nome;
	private int idade;
	private String email;
	private String tipoResidencial;
	private String preferenciasEnergeticas;
	
	public Usuario() {
		super();
	}


	public Usuario(String nome, int idade, String email, String tipoResidencial, String preferenciasEnergeticas) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.tipoResidencial = tipoResidencial;
		this.preferenciasEnergeticas = preferenciasEnergeticas;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipoResidencial() {
		return tipoResidencial;
	}


	public void setTipoResidencial(String tipoResidencial) {
		this.tipoResidencial = tipoResidencial;
	}


	public String getPreferenciasEnergeticas() {
		return preferenciasEnergeticas;
	}


	public void setPreferenciasEnergeticas(String preferenciasEnergeticas) {
		this.preferenciasEnergeticas = preferenciasEnergeticas;
	}



	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", idade=" + idade + ", email=" + email + ", tipoResidencial="
				+ tipoResidencial + ", preferenciasEnergeticas=" + preferenciasEnergeticas 
				+ "]";
	}
}
