package com.gmachado.gametech.service;

import com.gmachado.gametech.model.Games;
import com.gmachado.gametech.repository.GamesRepository;
import org.springframework.stereotype.Service;

@Service
public class GamesService {

    private final GamesRepository repository;

    public GamesService(GamesRepository repository) {
        this.repository = repository;
    }

    public Games getGames(String sort, String filters) {
        return repository.getGames(sort, filters).block();
    }
}
