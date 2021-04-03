package com.gmachado.gametech.representation;

import java.util.List;

public class PlatformsRepresentation {
    private List<PlatformRepresentation> platforms;

    public PlatformsRepresentation(List<PlatformRepresentation> platforms) {
        this.platforms = platforms;
    }

    public List<PlatformRepresentation> getPlatforms() {
        return platforms;
    }
}
