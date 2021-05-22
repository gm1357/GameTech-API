package com.gmachado.gametech.representation;

public record TokenRepresentation(String token, String type) {

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
