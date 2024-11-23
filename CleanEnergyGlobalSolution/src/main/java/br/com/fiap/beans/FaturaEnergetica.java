package br.com.fiap.beans;

import java.util.Date;

public class FaturaEnergetica {
    private int idFatura;
    private Usuario usuario;
    private double totalConsumo; // Consumo total em kWh
    private double valorFatura; // Valor total da fatura
    private Date periodoInicio;
    private Date periodoFim;

    public FaturaEnergetica() {
        super();
    }

    public FaturaEnergetica(int idFatura, Usuario usuario, double totalConsumo, double valorFatura, Date periodoInicio, Date periodoFim) {
        super();
        this.idFatura = idFatura;
        this.usuario = usuario;
        this.totalConsumo = totalConsumo;
        this.valorFatura = valorFatura;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
    }

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getTotalConsumo() {
        return totalConsumo;
    }

    public void setTotalConsumo(double totalConsumo) {
        this.totalConsumo = totalConsumo;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public Date getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Date periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public Date getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(Date periodoFim) {
        this.periodoFim = periodoFim;
    }

    @Override
    public String toString() {
        return "FaturaEnergetica [idFatura=" + idFatura + ", usuario=" + usuario + ", totalConsumo=" + totalConsumo
                + ", valorFatura=" + valorFatura + ", periodoInicio=" + periodoInicio + ", periodoFim=" + periodoFim + "]";
    }
}
