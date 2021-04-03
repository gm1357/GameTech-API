package com.gmachado.gametech.repository;

import com.gmachado.gametech.domain.PlatformsDomain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class PlatformsRepository {
    @Value("${api.key}")
    private String apiKey;
    private final WebClient webClient;
    private static final String JSON_FORMAT = "json";

    public PlatformsRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PlatformsDomain> getPlatforms() {
        String fields = "id,abbreviation,name";
        String url = String.format(
                "/platforms/?api_key=%s&format=%s&field_list=%s",
                apiKey, JSON_FORMAT, fields);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(PlatformsDomain.class);
    }
}
