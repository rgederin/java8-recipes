package com.gederin.java8.recipes.function;


import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * BiPredicate
 * LongPredicate
 * IntPredicate
 * DoublePredicate
 */
public class Predicates {

    public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;
    public static final Predicate<String> STARTS_WITH_S = s -> s.startsWith("S");

    /**
     * Finding strings of a given length
     */
    public String getNamesOfLength(int length, String... names) {
        return Arrays.stream(names)
                .filter(s -> s.length() == length)
                .collect(Collectors.joining(", "));
    }

    /**
     * Finding strings that start with a given string
     */
    public String getNamesStartingWith(String string, String... names) {
        return Arrays.stream(names).filter(s -> s.startsWith(string))
                .collect(Collectors.joining(", "));
    }

    /**
     * Finding strings that satisfy an arbitrary predicate
     */
    public String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {

        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }
}
