package br.com.fiap.beans;

import java.util.Date;

public class HistoricoConsumo {
    private int idHistorico;
    private Usuario usuario;
    private Dispositivo dispositivo;
    private double consumo; // Consumo em kWh
    private Date data;

    public HistoricoConsumo() {
        super();
    }

    public HistoricoConsumo(int idHistorico, Usuario usuario, Dispositivo dispositivo, double consumo, Date data) {
        super();
        this.idHistorico = idHistorico;
        this.usuario = usuario;
        this.dispositivo = dispositivo;
        this.consumo = consumo;
        this.data = data;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HistoricoConsumo [idHistorico=" + idHistorico + ", usuario=" + usuario + ", dispositivo=" + dispositivo
                + ", consumo=" + consumo + ", data=" + data + "]";
    }
}
