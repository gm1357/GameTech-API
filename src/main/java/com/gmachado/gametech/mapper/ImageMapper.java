package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.ImageDomain;
import com.gmachado.gametech.representation.ImageRepresentation;

public class ImageMapper {

    private ImageMapper() {}

    public static ImageRepresentation toRepresentation(ImageDomain domain) {
        ImageRepresentation representation = new ImageRepresentation();
        representation.setSmallUrl(domain.getSmallUrl());
        representation.setMediumUrl(domain.getMediumUrl());
        representation.setSuperUrl(domain.getSuperUrl());
        return representation;
    }
}
