package com.gmachado.gametech.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageRepresentation {
    @JsonProperty("small_url")
    private String smallUrl;

    @JsonProperty("medium_url")
    private String mediumUrl;

    @JsonProperty("super_url")
    private String superUrl;

    public String getSmallUrl() {
        return smallUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public String getSuperUrl() {
        return superUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public void setSuperUrl(String superUrl) {
        this.superUrl = superUrl;
    }
}
