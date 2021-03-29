package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.PlatformDomain;
import com.gmachado.gametech.representation.PlatformRepresentation;

public class PlatformMapper {

    private PlatformMapper() {}

    public static PlatformRepresentation toRepresentation(PlatformDomain domain) {
        PlatformRepresentation representation = new PlatformRepresentation();
        representation.setName(domain.getName());
        representation.setAbbreviation(domain.getAbbreviation());
        return representation;
    }
}
