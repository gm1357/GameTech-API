package com.gmachado.gametech.api;

import com.gmachado.gametech.model.Games;
import com.gmachado.gametech.service.GamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("public/games")
public class GamesApi {

    private final GamesService service;

    public GamesApi(GamesService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Games> getGames(@PathParam("sort") String sort, @PathParam("filters") String filters) {
        return ResponseEntity.ok(service.getGames(sort, filters));
    }
}
