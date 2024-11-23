package br.com.fiap.beans;

public class Dicas {
	private String nome;
	private String dica;
	private int id_dica;
	public Dicas(String nome, String dica, int id_dica) {
		super();
		this.nome = nome;
		this.dica = dica;
		this.id_dica = id_dica;
	}
	public Dicas() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	public int getId_dica() {
		return id_dica;
	}
	public void setId_dica(int id_dica) {
		this.id_dica = id_dica;
	}
	@Override
	public String toString() {
		return "Dicas [nome=" + nome + ", dica=" + dica + ", id_dica=" + id_dica + "]";
	}
}
