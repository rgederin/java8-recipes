package com.gederin.java8.recipes.optional;


import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalBasics {

    public static void main(String[] args) {
        Optional<String> firstEven =
                Stream.of("five", "even", "length", "string", "values")
                        .filter(s -> s.length() % 2 == 0)
                        .findFirst();


        /**
         * While this works, you’ve only traded null checking for isPresent checking, which
         * doesn’t feel like much of an improvement
         */
        System.out.println(
                firstEven.isPresent() ? firstEven.get() : "No even length strings");

        Optional<String> firstOdd =
                Stream.of("five", "even", "length", "string", "values")
                        .filter(s -> s.length() % 2 != 0)
                        .findFirst();

        /**
         * The orElse method returns the contained value if one is present,
         * or a supplied default otherwise.
         *
         * It’s therefore a convenient method to use if you have a fallback value in mind.
         */
        System.out.println(firstOdd.orElse("No odd length strings"));

        /**
         * The difference between orElse and orElseGet is that the former returns a string that
         * is always created, whether the value exists in the Optional or not,
         * while the latter uses a Supplier, which is only executed if the Optional is empty.
         */
        System.out.println(firstOdd.orElseGet(() -> "No odd length strings"));

        Optional<String> first =
                Stream.of("five", "even", "length", "string", "values")
                        .filter(s -> s.length() % 2 == 0)
                        .findFirst();

        /**
         * using orElseThrow
         */
        System.out.println(first.orElseThrow(NoSuchElementException::new));

        /**
         * ifPresent method allows you to provide a Consumer that is only executed
         * when the Optional contains a value
         */
        first.ifPresent(val -> System.out.println("Found an even-length string: " + val));
    }

    /**
     * Creating an Optional with “of ”
     */
    public static <T> Optional<T> createOptionalTheHardWay(T value) {
        return value == null ? Optional.empty() : Optional.of(value);
    }

    /**
     * OfNullable
     */
    public static <T> Optional<T> createOptionalTheEasyWay(T value) {
        return Optional.ofNullable(value);
    }
}
