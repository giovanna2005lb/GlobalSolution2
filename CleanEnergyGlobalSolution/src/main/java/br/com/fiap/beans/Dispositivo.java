package br.com.fiap.beans;

public class Dispositivo {
	private int id_dispositivo;
	private String tipo_dispositivo;
	private double consumoEnergia;
	private String status;
	private double potencia;
	private String localizacao_dispositivo;
	private Endereco endereco;
	
	
	
	public Dispositivo() {
		super();
	}
	public Dispositivo(int id_dispositivo, String tipo_dispositivo, double consumoEnergia, String status,
			double potencia, String localizacao_dispositivo) {
		super();
		this.id_dispositivo = id_dispositivo;
		this.tipo_dispositivo = tipo_dispositivo;
		this.consumoEnergia = consumoEnergia;
		this.status = status;
		this.potencia = potencia;
		this.localizacao_dispositivo = localizacao_dispositivo;
	}
	public int getId_dispositivo() {
		return id_dispositivo;
	}
	public void setId_dispositivo(int id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
	public String getTipo_dispositivo() {
		return tipo_dispositivo;
	}
	public void setTipo_dispositivo(String tipo_dispositivo) {
		this.tipo_dispositivo = tipo_dispositivo;
	}
	public double getConsumoEnergia() {
		return consumoEnergia;
	}
	public void setConsumoEnergia(double consumoEnergia) {
		this.consumoEnergia = consumoEnergia;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	public String getLocalizacao_dispositivo() {
		return localizacao_dispositivo;
	}
	public void setLocalizacao_dispositivo(String localizacao_dispositivo) {
		this.localizacao_dispositivo = localizacao_dispositivo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Dispositivo [id_dispositivo=" + id_dispositivo + ", tipo_dispositivo=" + tipo_dispositivo
				+ ", consumoEnergia=" + consumoEnergia + ", status=" + status + ", potencia=" + potencia
				+ ", localizacao_dispositivo=" + localizacao_dispositivo 
				+ ", endereco=" + endereco + "]";
	}
}
