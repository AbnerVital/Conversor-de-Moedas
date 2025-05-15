package br.com.alura.conversor.modelo;

public class TaxaDeCambio {
    private String codigoMoeda;
    private double taxa;

    public TaxaDeCambio(String codigoMoeda, double taxa) {
        this.codigoMoeda = codigoMoeda;
        this.taxa = taxa;
    }

    public String getCodigoMoeda() {
        return codigoMoeda;
    }

    public double getTaxa() {
        return taxa;
    }
}

