package com.gederin.java8.recipes.function;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;


/**
 * IntSupplier          int getAsInt()
 * DoubleSupplier       double getAsDouble()
 * LongSupplier         long getAsLong()
 * BooleanSupplier      boolean getAsBoolean()
 * Supplier             T get()
 */
public class Suppliers {

    /**
     * Using Math.random() as a Supplier
     */
    private static void useSuppliers() {

        //Anonymous inner class implementation
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };

        //Expression lambda
        randomSupplier = () -> Math.random();

        //Method reference
        randomSupplier = Math::random;
    }

    /**
     * Finding a name from a collection
     */
    private static void useSuppliers2() {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();

        //Prints Optional.empty
        System.out.println(first);

        //Prints the string "None"
        System.out.println(first.orElse("None"));

        //Forms the comma-separated collection, even when name is found
        System.out.println(first.orElse(String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));

        //Forms the comma-separated collection only if the Optional is empty
        System.out.println(first.orElseGet(() -> String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));
    }
}
