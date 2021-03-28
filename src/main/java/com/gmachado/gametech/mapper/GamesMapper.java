package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.GamesDomain;
import com.gmachado.gametech.representation.GamesRepresentation;

public class GamesMapper {

    private GamesMapper() {}

    public static GamesRepresentation toRepresentation(GamesDomain domain) {
        return new GamesRepresentation(
                domain.getResults().stream().map(GameSummaryMapper::toRepresentation).toList()
        );
    }
}
