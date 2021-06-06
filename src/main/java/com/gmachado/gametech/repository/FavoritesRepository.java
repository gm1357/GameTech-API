package com.gmachado.gametech.repository;

import com.gmachado.gametech.domain.FavoriteDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FavoritesRepository extends CrudRepository<FavoriteDomain, Long> {
    List<FavoriteDomain> findByUserId(Long userId);
}
