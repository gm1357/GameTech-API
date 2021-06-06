package com.gmachado.gametech.api;

import com.gmachado.gametech.domain.UserDomain;
import com.gmachado.gametech.representation.FavoriteRepresentation;
import com.gmachado.gametech.service.FavoritesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesApi {

    private final FavoritesService service;

    public FavoritesApi(FavoritesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FavoriteRepresentation> saveFavorite(@RequestBody @Valid FavoriteRepresentation representation,
                                                               UriComponentsBuilder uriBuilder,
                                                               Authentication authentication) {
        Long userId = ((UserDomain) authentication.getPrincipal()).getId();
        if (userId.equals(representation.getUserId())) {
            FavoriteRepresentation createdFavorite = service.saveFavorite(representation);
            URI uri = uriBuilder.path("/favorites/{id}").buildAndExpand(createdFavorite.getGameGuid()).toUri();
            return ResponseEntity.created(uri).body(createdFavorite);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong user ID");
        }
    }

    @GetMapping
    public ResponseEntity<List<FavoriteRepresentation>> getFavorites(@RequestParam Long userId,
                                                                     Authentication authentication) {
        Long authUserId = ((UserDomain) authentication.getPrincipal()).getId();
        if (userId.equals(authUserId)) {
            return ResponseEntity.ok(service.getFavorites(userId));
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong user ID");
        }
    }
}
