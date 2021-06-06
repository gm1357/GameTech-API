package com.gmachado.gametech.service;

import com.gmachado.gametech.domain.FavoriteDomain;
import com.gmachado.gametech.domain.GameSummaryDomain;
import com.gmachado.gametech.exception.GameNotFoundException;
import com.gmachado.gametech.mapper.FavoritesMapper;
import com.gmachado.gametech.repository.FavoritesRepository;
import com.gmachado.gametech.representation.FavoriteRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesService {

    private final FavoritesRepository repository;
    private final GamesService gamesService;

    public FavoritesService(FavoritesRepository repository, GamesService gamesService) {
        this.repository = repository;
        this.gamesService = gamesService;
    }

    public FavoriteRepresentation saveFavorite(FavoriteRepresentation representation) throws GameNotFoundException {
        GameSummaryDomain game = gamesService.getGameSummary(representation.getGameGuid());
        FavoriteDomain favoriteDomain = new FavoriteDomain();
        favoriteDomain.setGameGuid(game.getGuid());
        favoriteDomain.setCover(game.getImage().getSmallUrl());
        favoriteDomain.setDeck(Optional.ofNullable(game.getDeck()).orElse("").substring(0, 255));
        favoriteDomain.setUserId(representation.getUserId());
        return FavoritesMapper.toRepresentation(repository.save(favoriteDomain));
    }

    public List<FavoriteRepresentation> getFavorites(Long userId) {
        return FavoritesMapper.toRepresentation((List<FavoriteDomain>) repository.findByUserId(userId));
    }
}
