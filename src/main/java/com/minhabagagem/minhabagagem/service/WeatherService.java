package com.minhabagagem.minhabagagem.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhabagagem.minhabagagem.model.ClimaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.minhabagagem.minhabagagem.model.ClimaComSugestaoDTO;

import java.util.List;




@Service
public class WeatherService {

    private final String API_KEY = "86b8528c9f7e7ee44ab476c000cba688";
    private final String URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=pt_br";

    public ClimaDTO buscarClima(String cidade) {
        RestTemplate restTemplate = new RestTemplate();
        String urlFormatada = String.format(URL, cidade, API_KEY);

        try {
            String resposta = restTemplate.getForObject(urlFormatada, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode raiz = mapper.readTree(resposta);

            double temperatura = raiz.get("main").get("temp").asDouble();
            String descricao = raiz.get("weather").get(0).get("description").asText();
            String icone = raiz.get("weather").get(0).get("icon").asText();
            String iconeUrl = "https://openweathermap.org/img/wn/" + icone + ".png";

            return new ClimaDTO(cidade, temperatura, descricao, iconeUrl);
        } catch (Exception e) {
            return new ClimaDTO(cidade, 0, "Erro ao buscar o clima: " + e.getMessage(), "");
        }
    }

    public ClimaComSugestaoDTO buscarClimaComSugestao(String cidade) {
        ClimaDTO clima = buscarClima(cidade);
        List<String> sugestoes;

        if (clima.getTemperatura() >= 25) {
            sugestoes = List.of("É interessante adicionar na sua mala:","Roupas leves", "Protetor solar", "Óculos escuros", "Chinelo de dedo", "Chapéu ou boné");
        } else if (clima.getTemperatura() >= 18) {
            sugestoes = List.of("É interessante adicionar na sua mala:","Roupas confortáveis", "Casaquinho", "Saias ou vestidos leves");
        } else {
            sugestoes = List.of("É interessante adicionar na sua mala:", "Casaco", "Cachecol", "Roupas térmicas", "Gorro ou Touca de lã", "Botas impermeáveis e forradas");
        }

        return new ClimaComSugestaoDTO(
                clima.getCidade(),
                clima.getTemperatura(),
                clima.getDescricao(),
                clima.getIcone(),
                sugestoes
        );
    }

}
