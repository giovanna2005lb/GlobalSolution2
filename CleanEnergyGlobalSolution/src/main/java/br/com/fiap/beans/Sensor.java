package br.com.fiap.beans;

public class Sensor {
	private int id_sensor;
	private String tipo_sensor;
	private int valor;
	private String localizacao_sensor;
	private Endereco endereco;
	public Sensor() {
		super();
	}
	public Sensor(int id_sensor, String tipo_sensor, int valor, String localizacao_sensor) {
		super();
		this.id_sensor = id_sensor;
		this.tipo_sensor = tipo_sensor;
		this.valor = valor;
		this.localizacao_sensor = localizacao_sensor;
	}
	public int getId_sensor() {
		return id_sensor;
	}
	public void setId_sensor(int id_sensor) {
		this.id_sensor = id_sensor;
	}
	public String getTipo_sensor() {
		return tipo_sensor;
	}
	public void setTipo_sensor(String tipo_sensor) {
		this.tipo_sensor = tipo_sensor;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getLocalizacao_sensor() {
		return localizacao_sensor;
	}
	public void setLocalizacao_sensor(String localizacao_sensor) {
		this.localizacao_sensor = localizacao_sensor;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
