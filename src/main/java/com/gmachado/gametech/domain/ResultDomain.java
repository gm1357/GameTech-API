package com.gmachado.gametech.domain;

public class ResultDomain<T> {
    private T results;

    public ResultDomain() {}

    public ResultDomain(T results) {
        this.results = results;
    }

    public T getResults() {
        return results;
    }
}
