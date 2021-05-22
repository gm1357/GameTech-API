package com.gmachado.gametech.representation;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthRepresentation {
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsernamePasswordAuthenticationToken generateAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
