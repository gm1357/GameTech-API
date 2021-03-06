package com.gmachado.gametech.service;

import com.gmachado.gametech.domain.GameDetailDomain;
import com.gmachado.gametech.domain.GameSummaryDomain;
import com.gmachado.gametech.domain.GamesDomain;
import com.gmachado.gametech.domain.ResultDomain;
import com.gmachado.gametech.exception.GameNotFoundException;
import com.gmachado.gametech.repository.GamesRepository;
import org.springframework.core.codec.DecodingException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GamesService {

    private final GamesRepository repository;

    public GamesService(GamesRepository repository) {
        this.repository = repository;
    }

    public GamesDomain getGames(String sort, String filters, String offset) {
        return Optional
                .ofNullable(repository.getGames(sort, filters, offset).block())
                .orElse(new GamesDomain(new ArrayList<>()));
    }

    public GameDetailDomain getGame(String guid) throws GameNotFoundException {
        ResultDomain<GameDetailDomain> gameDetailDomainResultDomain;
        try {
            gameDetailDomainResultDomain = Optional
                    .ofNullable(repository.getGame(guid).block())
                    .orElse(new ResultDomain<>());
        } catch (DecodingException e) {
            throw new GameNotFoundException();
        }
        return gameDetailDomainResultDomain.getResults();
    }
    public GameSummaryDomain getGameSummary(String guid) throws GameNotFoundException {
        ResultDomain<GameSummaryDomain> gameSummaryDomainResultDomain;
        try {
            gameSummaryDomainResultDomain = Optional
                    .ofNullable(repository.getGameSummary(guid).block())
                    .orElse(new ResultDomain<>());
        } catch (DecodingException e) {
            throw new GameNotFoundException();
        }
        return gameSummaryDomainResultDomain.getResults();
    }
}
