package com.gmachado.gametech.representation;

public class GameSummaryRepresentation {
    private String name;
    private String deck;
    private String cover;

    public GameSummaryRepresentation(String name, String deck, String cover, String guid) {
        this.name = name;
        this.deck = deck;
        this.cover = cover;
        this.guid = guid;
    }

    private String guid;

    public String getName() {
        return name;
    }

    public String getDeck() {
        return deck;
    }

    public String getCover() {
        return cover;
    }

    public String getGuid() {
        return guid;
    }
}
