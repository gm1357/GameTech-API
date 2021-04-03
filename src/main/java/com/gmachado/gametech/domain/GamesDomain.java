package com.gmachado.gametech.domain;

import java.util.List;

public class GamesDomain {
    private List<GameSummaryDomain> results;

    public GamesDomain() {}

    public GamesDomain(List<GameSummaryDomain> results) {
        this.results = results;
    }

    public List<GameSummaryDomain> getResults() {
        return results;
    }
}
