package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.*;
import com.gmachado.gametech.representation.GameDetailRepresentation;

import java.util.ArrayList;
import java.util.Optional;

public class GameDetailMapper {

    private GameDetailMapper() {}

    public static GameDetailRepresentation toRepresentation(GameDetailDomain domain) {
        GameDetailRepresentation representation = new GameDetailRepresentation();
        representation.setDescription(
                Optional.ofNullable(domain.getDescription())
                        .orElse(""));
        representation.setName(domain.getName());
        representation.setDevelopers(
                Optional.ofNullable(domain.getDevelopers())
                        .orElse(new ArrayList<>())
                        .stream().map(DeveloperDomain::getName).toList());
        representation.setFranchises(
                Optional.ofNullable(domain.getFranchises())
                        .orElse(new ArrayList<>())
                        .stream().map(FranchiseDomain::getName).toList());
        representation.setGenres(
                Optional.ofNullable(domain.getGenres())
                        .orElse(new ArrayList<>())
                        .stream().map(GenreDomain::getName).toList());
        representation.setPublishers(
                Optional.ofNullable(domain.getPublishers())
                        .orElse(new ArrayList<>())
                        .stream().map(PublisherDomain::getName).toList());
        representation.setImages(
                Optional.ofNullable(domain.getImages())
                        .orElse(new ArrayList<>())
                        .stream().map(ImageMapper::toRepresentation).toList());
        representation.setPlatforms(
                Optional.ofNullable(domain.getPlatforms())
                        .orElse(new ArrayList<>())
                        .stream().map(PlatformMapper::toRepresentation).toList());
        return representation;
    }
}
