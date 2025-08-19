package br.com.seuusuario.conversormoedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CurrencyApiClient {

    private final String apiKey;
    private final HttpClient client;
    private final Gson gson;

    public CurrencyApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    // Busca todas as taxas de uma moeda base e filtra as 8 moedas do desafio
    public void printFilteredRates(String baseCurrency) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .timeout(Duration.ofSeconds(10))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status da requisição: " + response.statusCode());
            response.headers().map().forEach((k, v) -> System.out.println(k + " : " + v));

            if (response.statusCode() == 200) {
                JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
                String base = jsonObject.get("base_code").getAsString();
                System.out.println("Moeda base: " + base);

                JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

                // Moedas do desafio
                String[] moedasFiltro = {"ARS", "BOB", "BRL", "CLP", "COP", "USD", "EUR", "KRW"};

                for (String moeda : moedasFiltro) {
                    if (rates.has(moeda)) {
                        double valor = rates.get(moeda).getAsDouble();
                        System.out.println(moeda + ": " + valor);
                    }
                }

            } else {
                System.out.println("Erro na requisição: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Pega taxa específica entre duas moedas
    public double getConversionRate(String fromCurrency, String toCurrency) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + fromCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .timeout(Duration.ofSeconds(10))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonObject data = gson.fromJson(response.body(), JsonObject.class);
                if (data.has("conversion_rates")) {
                    return data.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1; // Indica erro
    }
}
