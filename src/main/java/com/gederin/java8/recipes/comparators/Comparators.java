package com.gederin.java8.recipes.comparators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class Comparators {

    public static void main(String[] args) {
        new Comparators().defaultSort();
    }

    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    /**
     * Default sort from Java 7 and below
     */
    public List<String> defaultSort() {
        Collections.sort(sampleStrings);

        System.out.println(sampleStrings);

        return sampleStrings;
    }

    /**
     * Default sort from Java 8 and above
     */
    public void defaultSortUsingStreams() {
        List<String> sorted = sampleStrings.stream()
                .sorted()
                .collect(toList());

        System.out.println(sampleStrings);
    }

    /**
     * Using a lambda for the Comparator to sort by length
     */
    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(toList());
    }

    /**
     * Using a Comparator using the comparingInt method
     */
    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList());
    }

    /**
     * Sorting by length, then equal lengths lexicographically
     */
    public List<String> lengthSortThenAlphaSort() {
        return sampleStrings.stream()
                .sorted(comparing(String::length)
                        .thenComparing(naturalOrder()))
                .collect(toList());
    }
}
