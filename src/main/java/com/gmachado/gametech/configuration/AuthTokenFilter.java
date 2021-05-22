package com.gmachado.gametech.configuration;

import com.gmachado.gametech.domain.UserDomain;
import com.gmachado.gametech.repository.UsersRepository;
import com.gmachado.gametech.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AuthTokenFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UsersRepository usersRepository;

    public AuthTokenFilter(TokenService tokenService, UsersRepository usersRepository) {
        this.tokenService = tokenService;
        this.usersRepository = usersRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getToken(request);
        boolean validToken = tokenService.isTokenValid(token);

        if (validToken) {
            authenticateClient(token);    
        }
        
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7);
    }

    private void authenticateClient(String token) {
        Long userId = tokenService.getUserId(token);
        Optional<UserDomain> optionalUser = usersRepository.findById(userId);

        if (optionalUser.isPresent()) {
            UserDomain user = optionalUser.get();
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
