package com.gmachado.gametech.domain;

import java.util.List;

public class GamesDomain {
    public GamesDomain() {}

    public GamesDomain(List<GameSummaryDomain> results) {
        this.results = results;
    }

    private List<GameSummaryDomain> results;

    public List<GameSummaryDomain> getResults() {
        return results;
    }
}
