package com.gmachado.gametech.representation;

public class GameSummaryRepresentation {
    private String name;
    private String deck;
    private String cover;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
