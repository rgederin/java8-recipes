package com.gederin.java8.recipes.streams;


import java.util.stream.IntStream;

public class LazyStreams {

    /**
     * The value 100 goes through the map to produce 200, but does not pass the filter, so the
     * stream moves to the value 101. That is mapped to 202, which also doesn’t pass the filter.
     * Then the next value, 102, is mapped to 204, but that is divisible by 3, so it passes. The
     * stream processing terminates a er processing only three values, using six operations.
     */
    public static void main(String[] args) {
        IntStream.range(100, 200)
                .map(LazyStreams::multByTwo)
                .filter(LazyStreams::divByThree)
                .findFirst();
    }

    public static int multByTwo(int n) {
        System.out.printf("Inside multByTwo with arg %d%n", n);
        return n * 2;
    }

    public static boolean divByThree(int n) {
        System.out.printf("Inside divByThree with arg %d%n", n);
        return n % 3 == 0;
    }
}
