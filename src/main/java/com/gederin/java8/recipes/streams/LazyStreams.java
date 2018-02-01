package com.gederin.java8.recipes.streams;


import java.util.stream.IntStream;

public class LazyStreams {

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
