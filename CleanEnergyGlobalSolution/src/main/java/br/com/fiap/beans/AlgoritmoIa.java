package br.com.fiap.beans;

public class AlgoritmoIa {
    private String nome;
    private String descricao;
    private double eficiencia;
    private String tipoModelo; 
    private String treinado;
	public AlgoritmoIa() {
		super();
	}
	public AlgoritmoIa(String nome, String descricao, double eficiencia, String tipoModelo, String treinado) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.eficiencia = eficiencia;
		this.tipoModelo = tipoModelo;
		this.treinado = treinado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(double eficiencia) {
		this.eficiencia = eficiencia;
	}
	public String getTipoModelo() {
		return tipoModelo;
	}
	public void setTipoModelo(String tipoModelo) {
		this.tipoModelo = tipoModelo;
	}
	public String getTreinado() {
		return treinado;
	}
	public void setTreinado(String treinado) {
		this.treinado = treinado;
	}
	@Override
	public String toString() {
		return "AlgoritimoIa [nome=" + nome + ", descricao=" + descricao + ", eficiencia=" + eficiencia
				+ ", tipoModelo=" + tipoModelo + ", treinado=" + treinado + "]";
	} 
}
