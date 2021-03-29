package com.gmachado.gametech.repository;

import com.gmachado.gametech.domain.GameDetailDomain;
import com.gmachado.gametech.domain.GamesDomain;
import com.gmachado.gametech.domain.ResultDomain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class GamesRepository {
    @Value("${api.key}")
    private String apiKey;
    private final WebClient webClient;
    private static final String JSON_FORMAT = "json";

    public GamesRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<GamesDomain> getGames(String sort, String filters) {
        String fields = "name,deck,image,guid";
        String url = String.format(
                "/games/?api_key=%s&format=%s&field_list=%s&sort=%s&filter=%s",
                apiKey, JSON_FORMAT, fields, sort, filters);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(GamesDomain.class);
    }

    public Mono<ResultDomain<GameDetailDomain>> getGame(String guid) {
        String fields = "name,description,developers,franchises,genres,platforms,publishers,images";
        String url = String.format(
                "/game/%s/?api_key=%s&format=%s&field_list=%s",
                guid, apiKey, JSON_FORMAT, fields);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }
}
