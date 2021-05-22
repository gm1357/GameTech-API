package com.gmachado.gametech.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
public class FavoritesApi {

    @GetMapping
    public ResponseEntity<Void> getFavorites() {
        return ResponseEntity.ok().build();
    }
}
