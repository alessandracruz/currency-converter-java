package com.alura.converter.service;

import com.alura.converter.domain.Conversion;
import com.alura.converter.model.Currency;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

/**
 * Implementação que consome a ExchangeRate-API (v6).
 * É obrigatório ter a variável de ambiente ER_API_KEY definida.
 */
public class ExchangeRateApiService implements ExchangeRateService {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6";

    @Override
    public Conversion convert(String from, String to, double amount) throws Exception {

        // valida siglas
        if (!Currency.contains(from) || !Currency.contains(to)) {
            throw new IllegalArgumentException("Código de moeda inválido.");
        }

        // obtém a chave
        String apiKey = System.getenv("ER_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Variável ER_API_KEY não configurada.");
        }

        // monta a URL: /v6/{KEY}/pair/{FROM}/{TO}/{AMOUNT}
        String uri = String.format(
                Locale.US,
                "%s/%s/pair/%s/%s/%.2f",
                BASE_URL,
                apiKey,
                from.toUpperCase(),
                to.toUpperCase(),
                amount);

        // faz requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // parse JSON
        JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();

        if (!"success".equals(root.get("result").getAsString())) {
            String error = root.has("error-type") ? root.get("error-type").getAsString() : "unknown";
            throw new RuntimeException("API error: " + error);
        }

        double rate      = root.get("conversion_rate").getAsDouble();
        double converted = root.get("conversion_result").getAsDouble();

        return new Conversion(
                Currency.valueOf(from.toUpperCase()),
                Currency.valueOf(to.toUpperCase()),
                rate,
                amount
        );
    }
}


