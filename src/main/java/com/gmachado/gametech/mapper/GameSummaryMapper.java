package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.GameSummaryDomain;
import com.gmachado.gametech.representation.GameSummaryRepresentation;

class GameSummaryMapper {

    private GameSummaryMapper() {}

    static GameSummaryRepresentation toRepresentation(GameSummaryDomain domain) {
        return new GameSummaryRepresentation(
                domain.getName(),
                domain.getDeck(),
                domain.getImage().getSmallUrl(),
                domain.getGuid()
        );
    }
}
