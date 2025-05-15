package br.com.alura.conversor.servico;

import br.com.alura.conversor.exception.ErroDeMoedaException;
import br.com.alura.conversor.modelo.TaxaDeCambio;

public class ConversorDeMoeda {

    private final ClienteApiMoeda clienteApi = new ClienteApiMoeda();

    public double converterParaUSD(String moedaOrigem, double valor) throws ErroDeMoedaException {
        TaxaDeCambio taxa = clienteApi.buscarTaxaParaUSD(moedaOrigem);
        return valor * taxa.getTaxa();
    }

    public double converterDeUSD(String moedaDestino, double valor) throws ErroDeMoedaException {
        TaxaDeCambio taxa = clienteApi.buscarTaxaDeUSD(moedaDestino);
        return valor * taxa.getTaxa();
    }
}

