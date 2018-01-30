package com.gederin.java8.recipes.streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ReduceOperations {
    private static String[] strings = "this is an array of strings".split(" ");

    private static void count() {
        long count = Arrays.stream(strings)
                .map(String::length)
                .count();

        System.out.println("There are " + count + " strings");
    }

    private static void sum() {
        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();

        System.out.println("The total length is " + totalLength);
    }

    private static void average() {
        OptionalDouble ave = Arrays.stream(strings)
                .mapToInt(String::length)
                .average();

        System.out.println("The average length is " + ave);
    }

    private static void minMax() {
        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length)
                .max();

        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min();

        System.out.println("The max and min lengths are " + max + " and " + min);
    }

    /**
     * You want the count, sum, min, max, and average of a stream of numerical values.
     */
    private static void useSummaryStatistics(){
        DoubleSummaryStatistics stats = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .summaryStatistics();

        System.out.println(stats);
        System.out.println("count: " + stats.getCount());
        System.out.println("min  : " + stats.getMin());
        System.out.println("max  : " + stats.getMax());
        System.out.println("sum  : " + stats.getSum());
        System.out.println("ave  : " + stats.getAverage());
    }

    /**
     * Summing numbers using reduce
     */
    private static void useReduce() {
        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + y)
                .orElse(0);

        /**
         * In the lambda expression, you can think of the
         * first argument of the binary operator as an accumulator,
         * and the second argument as the value of each element in the stream.
         */
        IntStream.rangeClosed(1, 10).reduce((x, y) -> {
            System.out.printf("x=%d, y=%d%n", x, y);

            return x + y;
        }).orElse(0);
    }

    /**
     * The demonstrations used in this recipe referred to the first argument as an initial value for
     * the accumulator, even though the method signature called it identity. The word identity means
     * that you should supply a value to the binary operator that, when combined with any other
     * value, returns the other value. For addition, the iden‐ tity is zero. For multiplication, the
     * identity is 1. For string concatenation, the identity is the empty string.
     */
    private static void useIdentityInReduce() {
        int doubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> x + 2 * y);
    }
}
