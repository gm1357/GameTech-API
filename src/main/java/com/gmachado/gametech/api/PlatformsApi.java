package com.gmachado.gametech.api;

import com.gmachado.gametech.mapper.GamesMapper;
import com.gmachado.gametech.mapper.PlatformsMapper;
import com.gmachado.gametech.representation.GamesRepresentation;
import com.gmachado.gametech.representation.PlatformsRepresentation;
import com.gmachado.gametech.service.PlatformsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("public/platforms")
public class PlatformsApi {

    private PlatformsService service;

    public PlatformsApi(PlatformsService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PlatformsRepresentation> getPlatforms() {
        return ResponseEntity.ok(
                PlatformsMapper.toRepresentation(
                        service.getPlatforms()
                )
        );
    }
}
