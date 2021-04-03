package com.gmachado.gametech.service;

import com.gmachado.gametech.domain.PlatformsDomain;
import com.gmachado.gametech.repository.PlatformsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlatformsService {
    private PlatformsRepository repository;

    public PlatformsService(PlatformsRepository repository) {
        this.repository = repository;
    }

    public PlatformsDomain getPlatforms() {
        return Optional
                .ofNullable(repository.getPlatforms().block())
                .orElse(new PlatformsDomain(new ArrayList<>()));
    }
}
