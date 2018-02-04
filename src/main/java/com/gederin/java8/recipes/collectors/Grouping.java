package com.gederin.java8.recipes.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        usePartioning();
        useGrouping();
    }

    /**
     * Partitioning strings by even or odd lengths
     *
     * Map as a result that has exactly two entries: a list of values that satisfy the Predicate,
     * and a list of values that do not.
     */
    static void usePartioning() {
        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");

        Map<Boolean, List<String>> lengthMap = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));

        lengthMap.forEach((key, value) -> System.out.printf("%5s: %s%n", key, value));
    }

    /**
     * The groupingBy method performs an operation like a “group by” statement in SQL. It returns a
     * Map where the keys are the groups and the values are lists of elements in each group.
     *
     * Grouping strings by length
     */
    static void useGrouping() {
        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");

        Map<Integer, List<String>> lengthMap = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        lengthMap.forEach((k, v) -> System.out.printf("%d: %s%n", k, v));
    }

    /**
     * This is called a downstream collector, because it is postprocessing the resulting lists
     * downstream (i.e., after the partitioning operation is completed).
     *
     * Counting the partitioned strings
     */
    static void downstream() {
        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");


        Map<Boolean, Long> numberLengthMap = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0,
                        Collectors.counting()));

        numberLengthMap.forEach((k, v) -> System.out.printf("%5s: %d%n", k, v));
    }
}
