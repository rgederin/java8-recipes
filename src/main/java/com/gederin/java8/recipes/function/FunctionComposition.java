package com.gederin.java8.recipes.function;

import java.util.function.Function;

public class FunctionComposition {

    public static void main(String[] args) {
        Function<Integer, Integer> add2 = x -> x + 2;
        Function<Integer, Integer> mult3 = x -> x * 3;

        /**
         *  Using the compose and and en methods
         */
        Function<Integer, Integer> mult3add2 = add2.compose(mult3);
        Function<Integer, Integer> add2mult3 = add2.andThen(mult3);

        System.out.println("mult3add2(1): " + mult3add2.apply(1));
        System.out.println("add2mult3(1): " + add2mult3.apply(1));

        /**
         * Parse an integer from a string, then add 2
         */
        Function<String, Integer> parseThenAdd2 = add2.compose(Integer::parseInt);
        System.out.println(parseThenAdd2.apply("1"));

        /**
         * Add a number, then convert to a string
         */
        Function<Integer, String> plus2toString = add2.andThen(Object::toString);
        System.out.println(plus2toString.apply(1));
    }
}
