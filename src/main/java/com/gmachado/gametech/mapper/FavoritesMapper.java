package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.FavoriteDomain;
import com.gmachado.gametech.representation.FavoriteRepresentation;

import java.util.List;
import java.util.stream.Collectors;

public class FavoritesMapper {
    public static FavoriteRepresentation toRepresentation(FavoriteDomain domain) {
        FavoriteRepresentation representation = new FavoriteRepresentation();
        representation.setGameGuid(domain.getGameGuid());
        representation.setCover(domain.getCover());
        representation.setDeck(domain.getDeck());
        representation.setUserId(domain.getUserId());
        return representation;
    }

    public static List<FavoriteRepresentation> toRepresentation(List<FavoriteDomain> domains) {
        return domains.stream().map(FavoritesMapper::toRepresentation).collect(Collectors.toList());
    }
}
