package com.gmachado.gametech.api;

import com.gmachado.gametech.mapper.GameDetailMapper;
import com.gmachado.gametech.mapper.GamesMapper;
import com.gmachado.gametech.representation.GameDetailRepresentation;
import com.gmachado.gametech.representation.GamesRepresentation;
import com.gmachado.gametech.service.GamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<GamesRepresentation> getGames(@PathParam("sort") String sort, @PathParam("filters") String filters) {
        return ResponseEntity.ok(
                GamesMapper.toRepresentation(
                        service.getGames(sort, filters)
                )
        );
    }

    @RequestMapping(value = "/{guid}", method = RequestMethod.GET)
    public ResponseEntity<GameDetailRepresentation> getGame(@PathVariable("guid") String guid) {
        return ResponseEntity.ok(
                GameDetailMapper.toRepresentation(
                        service.getGame(guid)
                )
        );
    }
}
