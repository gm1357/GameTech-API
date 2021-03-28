package com.gmachado.gametech.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GamesRepresentation {
    public GamesRepresentation(List<GameSummaryRepresentation> games) {
        this.games = games;
    }

    public List<GameSummaryRepresentation> getGames() {
        return games;
    }

    private List<GameSummaryRepresentation> games;
}
