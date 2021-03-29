package com.gmachado.gametech.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameDetailDomain {
    private String name;
    private String description;
    private List<DeveloperDomain> developers;
    private List<FranchiseDomain> franchises;
    private List<GenreDomain> genres;
    private List<PlatformDomain> platforms;
    private List<PublisherDomain> publishers;
    private List<ImageDomain> images;

    public GameDetailDomain() {}

    public GameDetailDomain(String name, String description, List<DeveloperDomain> developers, List<FranchiseDomain> franchises, List<GenreDomain> genres, List<PlatformDomain> platforms, List<PublisherDomain> publishers, List<ImageDomain> images) {
        this.name = name;
        this.description = description;
        this.developers = developers;
        this.franchises = franchises;
        this.genres = genres;
        this.platforms = platforms;
        this.publishers = publishers;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<DeveloperDomain> getDevelopers() {
        return developers;
    }

    public List<FranchiseDomain> getFranchises() {
        return franchises;
    }

    public List<GenreDomain> getGenres() {
        return genres;
    }

    public List<PlatformDomain> getPlatforms() {
        return platforms;
    }

    public List<PublisherDomain> getPublishers() {
        return publishers;
    }

    public List<ImageDomain> getImages() {
        return images;
    }
}
