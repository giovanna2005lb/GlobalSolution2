package br.com.fiap.beans;

import java.util.Date;

public class ConsumoEnergetico {
    private int idConsumo;
    private double consumo; // Consumo em kWh
    private double custo;   // Custo estimado
    private Dispositivo dispositivo; // Dispositivo associado ao consumo
    private Date dataHora;

    public ConsumoEnergetico() {
        super();
    }

    public ConsumoEnergetico(int idConsumo, double consumo, double custo, Dispositivo dispositivo, Date dataHora) {
        super();
        this.idConsumo = idConsumo;
        this.consumo = consumo;
        this.custo = custo;
        this.dispositivo = dispositivo;
        this.dataHora = dataHora;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "ConsumoEnergetico [idConsumo=" + idConsumo + ", consumo=" + consumo + ", custo=" + custo
                + ", dispositivo=" + dispositivo + ", dataHora=" + dataHora + "]";
    }
}
