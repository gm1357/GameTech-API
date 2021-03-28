package com.gmachado.gametech.service;

import com.gmachado.gametech.domain.GamesDomain;
import com.gmachado.gametech.representation.GameDetailRepresentation;
import com.gmachado.gametech.repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GamesService {

    private final GamesRepository repository;

    public GamesService(GamesRepository repository) {
        this.repository = repository;
    }

    public GamesDomain getGames(String sort, String filters) {
        return Optional
                .ofNullable(repository.getGames(sort, filters).block())
                .orElse(new GamesDomain(new ArrayList<>()));
    }
}
