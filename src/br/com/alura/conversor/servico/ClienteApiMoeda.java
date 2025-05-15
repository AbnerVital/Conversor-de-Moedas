package br.com.alura.conversor.servico;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.alura.conversor.exception.ErroDeMoedaException;
import br.com.alura.conversor.modelo.TaxaDeCambio;
import com.google.gson.Gson;
import org.json.JSONObject;

public class ClienteApiMoeda {

    private static final String URL_API = "https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/";

    public TaxaDeCambio buscarTaxaParaUSD(String moedaOrigem) throws ErroDeMoedaException {
        try {
            Gson gson = new Gson();
            String url = URL_API + moedaOrigem;
            HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();

            conexao.setRequestMethod("GET");
            conexao.connect();

            if (conexao.getResponseCode() != 200) {
                throw new ErroDeMoedaException("Erro na API: código " + conexao.getResponseCode());
            }

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder json = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                json.append(linha);
            }

            JSONObject resposta = new JSONObject(json.toString());
            double taxa = resposta.getJSONObject("conversion_rates").getDouble("USD");

            return new TaxaDeCambio("USD", taxa);
        } catch (Exception e) {
            throw new ErroDeMoedaException("Erro ao buscar taxa: " + e.getMessage());
        }
    }

    public TaxaDeCambio buscarTaxaDeUSD(String moedaDestino) throws ErroDeMoedaException {
        try {
            String url = URL_API + "USD";
            HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();

            conexao.setRequestMethod("GET");
            conexao.connect();

            if (conexao.getResponseCode() != 200) {
                throw new ErroDeMoedaException("Erro na API: código " + conexao.getResponseCode());
            }

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder json = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                json.append(linha);
            }

            JSONObject resposta = new JSONObject(json.toString());
            double taxa = resposta.getJSONObject("conversion_rates").getDouble(moedaDestino);

            return new TaxaDeCambio(moedaDestino, taxa);
        } catch (Exception e) {
            throw new ErroDeMoedaException("Erro ao buscar taxa: " + e.getMessage());
        }
    }
}

