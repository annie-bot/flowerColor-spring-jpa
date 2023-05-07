package com.flowercolor.shop.services;

import java.io.IOException;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CepApiValidator {
    public static void main(String[] args) throws IOException {
        String cep = "01001000"; // CEP que deseja pesquisar
        String url = "http://cep.la/api" + cep;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
                String line;
                StringBuilder result = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                Gson gson = new Gson();
                CepLaApiResponse apiResponse = gson.fromJson(result.toString(), CepLaApiResponse.class);

                String address = apiResponse.getLogradouro();
                String city = apiResponse.getCidade();
            }
        }
    }

    static class CepLaApiResponse {
        private String cep;
        private String rua;
        private String bairro;
        private String cidade;
        private String uf;


        public String getCep() {
            return cep;
        }

        public String getLogradouro() {
            return rua;
        }

        public String getBairro() {
            return bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public String getUf() {
            return uf;
        }

    }
}

