package com.gmachado.gametech.representation;

import java.util.List;

public class GameDetailRepresentation {
    private String description;
    private String name;
    private List<String> developers;
    private List<String> franchises;
    private List<String> genres;
    private List<PlatformRepresentation> platforms;
    private List<String> publishers;
    private List<ImageRepresentation> images;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<String> getDevelopers() {
        return developers;
    }

    public List<String> getFranchises() {
        return franchises;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public List<PlatformRepresentation> getPlatforms() {
        return platforms;
    }

    public List<ImageRepresentation> getImages() {
        return images;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }

    public void setFranchises(List<String> franchises) {
        this.franchises = franchises;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setPlatforms(List<PlatformRepresentation> platforms) {
        this.platforms = platforms;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    public void setImages(List<ImageRepresentation> images) {
        this.images = images;
    }
}
