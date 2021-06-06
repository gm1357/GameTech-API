package com.gmachado.gametech.api;

import com.gmachado.gametech.exception.GameNotFoundException;
import com.gmachado.gametech.mapper.GameDetailMapper;
import com.gmachado.gametech.mapper.GamesMapper;
import com.gmachado.gametech.representation.GameDetailRepresentation;
import com.gmachado.gametech.representation.GamesRepresentation;
import com.gmachado.gametech.service.GamesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("public/games")
public class GamesApi {

    private final GamesService service;

    public GamesApi(GamesService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<GamesRepresentation> getGames(
            @PathParam("sort") String sort,
            @PathParam("filters") String filters,
            @PathParam("offset") String offset) {
        return ResponseEntity.ok(
                GamesMapper.toRepresentation(
                        service.getGames(sort, filters, offset)
                )
        );
    }

    @RequestMapping(value = "/{guid}", method = RequestMethod.GET)
    public ResponseEntity<GameDetailRepresentation> getGame(@PathVariable("guid") String guid) {
        try {
            return ResponseEntity.ok(
                    GameDetailMapper.toRepresentation(
                            service.getGame(guid)
                    )
            );
        } catch (GameNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Game with id %s not found", guid));
        }
    }
}
