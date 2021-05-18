package com.gmachado.gametech.service;

import com.gmachado.gametech.domain.UserDomain;
import com.gmachado.gametech.mapper.UserMapper;
import com.gmachado.gametech.repository.UsersRepository;
import com.gmachado.gametech.representation.UserRepresentation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {

    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public UserRepresentation createUser(UserRepresentation newUser) {
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        UserDomain createdUser = repository.save(UserMapper.toDomain(newUser));
        return UserMapper.toRepresentation(createdUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
