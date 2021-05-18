package com.gmachado.gametech.api;

import com.gmachado.gametech.representation.UserRepresentation;
import com.gmachado.gametech.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("public/users")
public class UsersApi {

    private final UsersService service;

    public UsersApi(UsersService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserRepresentation> createUser(@Valid @RequestBody UserRepresentation user) {
        return ResponseEntity.created(null).body(service.createUser(user));
    }
}
