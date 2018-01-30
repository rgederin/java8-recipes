package com.gederin.java8.recipes.streams;


import java.util.stream.IntStream;

public class Peek {

    public static void main(String[] args) {
        sumDoublesDivisibleBy3(10, 200);
    }

    /**
     * Using multiple peek methods
     */
    public static int sumDoublesDivisibleBy3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .peek(n -> System.out.printf("original: %d%n", n)).map(n -> n * 2)
                .peek(n -> System.out.printf("doubled : %d%n", n)).filter(n -> n % 3 == 0)
                .peek(n -> System.out.printf("filtered: %d%n", n))
                .sum();
    }
}
