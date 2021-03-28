package com.gmachado.gametech.repository;

import com.gmachado.gametech.model.Games;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.*;
import reactor.core.publisher.Mono;

@Repository
public class GamesRepository {
    @Value("${api.key}")
    private String apiKey;
    private final WebClient webClient;

    public GamesRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Games> getGames(String sort, String filters) {
        String url = "/games/?api_key=" + apiKey +
                "&format=json" +
                "&field_list=name,deck,cover,guid" +
                "&sort=" + sort +
                "&filter=" + filters;
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Games.class);
    }
}
