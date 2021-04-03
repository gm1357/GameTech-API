package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.PlatformsDomain;
import com.gmachado.gametech.representation.PlatformsRepresentation;

public class PlatformsMapper {

    private PlatformsMapper() {}

    public static PlatformsRepresentation toRepresentation(PlatformsDomain domain) {
        return new PlatformsRepresentation(
                domain.getResults().stream().map(PlatformMapper::toRepresentation).toList()
        );
    }
}
