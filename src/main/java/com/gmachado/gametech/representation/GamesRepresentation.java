package com.gmachado.gametech.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GamesRepresentation {
    private List<GameSummaryRepresentation> games;

    public GamesRepresentation(List<GameSummaryRepresentation> games) {
        this.games = games;
    }

    public List<GameSummaryRepresentation> getGames() {
        return games;
    }
}
