package com.gmachado.gametech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Games {
    @JsonProperty("results")
    private List<Game> games;
}
