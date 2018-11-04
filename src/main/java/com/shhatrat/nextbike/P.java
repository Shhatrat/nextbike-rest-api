package com.shhatrat.nextbike;

public class P<S, T> {

    private final S first;
    private final T second;


    public P(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
