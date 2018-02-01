package com.gederin.java8.recipes.streams;


import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Findings {

    public static void main(String[] args) {
        useMathcers();
    }

    /**
     * Finding the  rst even integer. For both sequential and parallel case rsults will be the same
     */
    private static void useFindFirst() {
        Optional<Integer> firstEven =
                Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                        .filter(n -> n % 2 == 0)
                        .findFirst();

        System.out.println(firstEven.get());

        firstEven = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .parallel()
                .filter(n -> n % 2 == 0)
                .findFirst();

        System.out.println(firstEven.get());
    }

    /**
     * Using findAny in parallel streams - results will differ from time to time
     */
    private static void useFindAny() {
        Optional<Integer> firstEven =
                Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                        .parallel()
                        .filter(n -> n % 2 == 0)
                        .findAny();

        System.out.println(firstEven.get());
    }

    private static boolean isPrime(int num) {
        int limit = (int) (Math.sqrt(num) + 1);

        return num == 2 || num > 1 && IntStream.range(2, limit).noneMatch(divisor -> num % divisor == 0);
    }

    private static void useMathcers() {
        boolean match = IntStream.of(2, 3, 5, 7, 11, 13, 17, 19)
                .allMatch(Findings::isPrime);

        System.out.println(match);

        match = Stream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20)
                .anyMatch(Findings::isPrime);

        System.out.println(match);
    }
}
