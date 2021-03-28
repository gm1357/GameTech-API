package com.gmachado.gametech.repository;

import com.gmachado.gametech.domain.GamesDomain;
import com.gmachado.gametech.representation.GameDetailRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class GamesRepository {
    @Value("${api.key}")
    private String apiKey;
    private final WebClient webClient;

    public GamesRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<GamesDomain> getGames(String sort, String filters) {
        String url = "/games/?api_key=" + apiKey +
                "&format=json" +
                "&field_list=name,deck,image,guid" +
                "&sort=" + sort +
                "&filter=" + filters;
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(GamesDomain.class);
    }
}
