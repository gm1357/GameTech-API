package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.GameSummaryDomain;
import com.gmachado.gametech.representation.GameSummaryRepresentation;

import java.util.Optional;

class GameSummaryMapper {

    private GameSummaryMapper() {}

    static GameSummaryRepresentation toRepresentation(GameSummaryDomain domain) {
        GameSummaryRepresentation representation = new GameSummaryRepresentation();
        representation.setCover(domain.getImage().getSmallUrl());
        representation.setDeck(Optional.ofNullable(domain.getDeck()).orElse(""));
        representation.setGuid(domain.getGuid());
        representation.setName(domain.getName());
        return representation;
    }
}
