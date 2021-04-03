package com.gmachado.gametech.domain;

import java.util.List;

public class PlatformsDomain {
    private List<PlatformDomain> results;

    public PlatformsDomain() {}

    public PlatformsDomain(List<PlatformDomain> results) {
        this.results = results;
    }

    public List<PlatformDomain> getResults() {
        return results;
    }
}
