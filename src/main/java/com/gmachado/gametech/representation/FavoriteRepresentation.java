package com.gmachado.gametech.representation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FavoriteRepresentation {
    @NotBlank
    private String gameGuid;
    @NotNull
    private Long userId;
    private String deck;
    private String cover;

    public String getGameGuid() {
        return gameGuid;
    }

    public void setGameGuid(String gameGuid) {
        this.gameGuid = gameGuid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
