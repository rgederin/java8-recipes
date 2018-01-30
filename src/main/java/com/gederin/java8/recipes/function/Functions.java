package com.gederin.java8.recipes.function;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * IntFunction              R apply(int value)
 * DoubleFunction           R apply(double value)
 * LongFunction             R apply(long value)
 * ToIntFunction            int applyAsInt(T value)
 * ToDoubleFunction         double applyAsDouble(T value)
 * ToLongFunction           long applyAsLong(T value)
 * DoubleToIntFunction      int applyAsInt(doublevalue)
 * DoubleToLongFunction     long applyAsLong(double value)
 * IntToDoubleFunction      double applyAsDouble(intvalue)
 * IntToLongFunction        long applyAsLong(int value)
 * LongToDoubleFunction     double applyAsDouble(long value)
 * LongToIntFunction        int applyAsInt(long value)
 * BiFunction               void accept(T t, U u)
 * ToIntBiFunction          int applyAsInt(T t, U u)
 * ToDoubleBiFunction       double applyAsDouble(T t, U u)
 * ToLongBiFunction         long applyAsLong(T t, U u)
 */
public class Functions {
    private static void useFunctions() {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        //Anonymous inner class
        List<Integer> nameLengths = names.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }).collect(Collectors.toList());

        //Lambda expression
        nameLengths = names.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());

        //Method reference
        nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
