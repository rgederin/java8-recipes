package com.gederin.java8.recipes.streams;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concatenating {

    public static void main(String[] args) {
        concatWithReduce();
    }

    /**
     * Concatenating two streams
     */
    public static void concatTwo() {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");

        Stream.concat(first, second)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    public static void concatThree() {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        Stream<String> third = Stream.of("alpha", "beta", "gamma");

        Stream.concat(Stream.concat(first, second), third)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void concatWithReduce() {
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("X", "Y", "Z");
        Stream<String> third = Stream.of("alpha", "beta", "gamma");
        Stream<String> fourth = Stream.empty();

        Stream.of(first, second, third, fourth)
                .reduce(Stream.empty(), Stream::concat)
                .forEach(System.out::println);
    }

    public static void concatWithFlatMap() {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        Stream<String> third = Stream.of("alpha", "beta", "gamma");
        Stream<String> fourth = Stream.empty();

        List<String> strings = Stream.of(first, second, third, fourth)
                .flatMap(Function.identity())
                .collect(Collectors.toList());
    }
}
