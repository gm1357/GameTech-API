package com.gmachado.gametech.api;

import com.gmachado.gametech.representation.AuthRepresentation;
import com.gmachado.gametech.representation.TokenRepresentation;
import com.gmachado.gametech.representation.UserRepresentation;
import com.gmachado.gametech.service.TokenService;
import com.gmachado.gametech.service.UsersService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("public/users")
public class UsersApi {

    private final UsersService service;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public UsersApi(UsersService service, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.service = service;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<UserRepresentation> createUser(@Valid @RequestBody UserRepresentation user) {
        return ResponseEntity.created(null).body(service.createUser(user));
    }

    @PostMapping("/auth")
    public ResponseEntity<TokenRepresentation> authenticate(@RequestBody @Valid AuthRepresentation auth) {
        UsernamePasswordAuthenticationToken authenticationToken = auth.generateAuthenticationToken();
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            String token = tokenService.getToken(authentication);

            return ResponseEntity.ok(new TokenRepresentation(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
