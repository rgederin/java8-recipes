package com.gederin.java8.recipes;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReference {

    /**
     * Using a method reference to access println
     */
    private static void methodReference() {
        //Using a lambda expression
        Stream.of(3, 1, 4, 1, 5, 9).forEach(x -> System.out.println(x));

        //Using a method reference
        Stream.of(3, 1, 4, 1, 5, 9).forEach(System.out::println);

        //Assigning the method reference to a functional interface
        Consumer<Integer> printer = System.out::println;

        Stream.of(3, 1, 4, 1, 5, 9).forEach(printer);
    }

    /**
     * Using a method reference to a static method
     */
    private static void staticMethodReference() {
        Stream.generate(Math::random)          //Static method
                .limit(10)
                .forEach(System.out::println); //Instance method
    }

    /**
     * Invoking a multiple-argument instance method from a class reference
     */
    private static void multipleArgumentClassReference() {

        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        //lambda
        List<String> sorted1 = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());

        //Method reference
        List<String> sorted2 = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

    }

    /**
     * Invoking the length method on String using a method reference and lambda
     */
    private static void methodReferenceAndLambda() {
        Stream.of("this", "is", "a", "stream", "of", "strings")
                .map(String::length)             //Instance method via class name
                .forEach(System.out::println);   //Instance method via object reference

        Stream.of("this", "is", "a", "stream", "of", "strings")
                .map(s -> s.length())
                .forEach(x -> System.out.println(x));
    }
}
