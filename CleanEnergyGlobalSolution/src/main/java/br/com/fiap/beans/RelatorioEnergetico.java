package br.com.fiap.beans;

import java.util.List;

public class RelatorioEnergetico {
    private int idRelatorio;
    private Usuario usuario;
    private List<ConsumoEnergetico> consumos;
    private double consumoTotal; // Consumo total do período
    private double custoTotal; // Custo total do período

    public RelatorioEnergetico() {
        super();
    }

    public RelatorioEnergetico(int idRelatorio, Usuario usuario, List<ConsumoEnergetico> consumos, double consumoTotal, double custoTotal) {
        super();
        this.idRelatorio = idRelatorio;
        this.usuario = usuario;
        this.consumos = consumos;
        this.consumoTotal = consumoTotal;
        this.custoTotal = custoTotal;
    }

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ConsumoEnergetico> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<ConsumoEnergetico> consumos) {
        this.consumos = consumos;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    @Override
    public String toString() {
        return "RelatorioEnergetico [idRelatorio=" + idRelatorio + ", usuario=" + usuario + ", consumoTotal="
                + consumoTotal + ", custoTotal=" + custoTotal + ", consumos=" + consumos + "]";
    }
}
