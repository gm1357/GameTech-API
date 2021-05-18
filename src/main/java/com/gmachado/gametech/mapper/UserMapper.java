package com.gmachado.gametech.mapper;

import com.gmachado.gametech.domain.UserDomain;
import com.gmachado.gametech.representation.UserRepresentation;

public class UserMapper {

    public static UserDomain toDomain(UserRepresentation representation) {
        UserDomain domain = new UserDomain();
        domain.setId(representation.getId());
        domain.setName(representation.getName());
        domain.setEmail(representation.getEmail());
        domain.setPassword(representation.getPassword());
        return domain;
    }

    public static UserRepresentation toRepresentation(UserDomain domain) {
        UserRepresentation representation = new UserRepresentation();
        representation.setId(domain.getId());
        representation.setName(domain.getName());
        representation.setEmail(domain.getEmail());
        representation.setPassword(domain.getPassword());
        return representation;
    }
}
