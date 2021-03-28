package com.gmachado.gametech.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDomain {
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
}
