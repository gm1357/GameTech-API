package com.gmachado.gametech.repository;

import com.gmachado.gametech.domain.UserDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<UserDomain, Long> {
    public Optional<UserDomain> findByEmail(String email);
}
