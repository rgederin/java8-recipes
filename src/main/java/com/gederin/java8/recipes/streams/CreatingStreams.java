package com.gederin.java8.recipes.streams;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream.of(T... values) and Stream.of(T t) • Arrays.stream(T[] array), with overloads for int[],
 * double[], and long[] • Stream.iterate(T seed, UnaryOperator<T> f) • Stream.generate(Supplier<T>
 * s) • Collection.stream() • Using range and rangeClosed: — IntStream.range(int startInclusive, int
 * endExclusive) — IntStream.rangeClosed(int startInclusive, int endInclusive) —
 * LongStream.range(long startInclusive, long endExclusive) — LongStream.rangeClosed(long
 * startInclusive, long endInclusive)
 */
public class CreatingStreams {
    /**
     * Creating a stream using Stream.of
     */
    private static void useStreamOf() {
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(","));
    }

    /**
     * Creating a stream using Arrays.stream
     */
    private static void useArraysStream() {
        String[] munsters = {"Herman", "Lily", "Eddie", "Marilyn", "Grandpa"};

        String results = Arrays.stream(munsters)
                .collect(Collectors.joining(","));
    }

    /**
     * Creating a stream using Stream.iterate
     */
    private static void useIterate() {
        List<BigDecimal> nums = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(nums);   // prints [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);  // prints 10 days starting from today
    }

    /**
     * Creating a stream of random doubles
     */
    private static void usGenerate() {
        Stream.generate(Math::random).limit(10)
                .forEach(System.out::println);
    }

    /**
     * Creating a stream from a collection
     */
    private static void createStreamFromCollection() {
        List<String> bradyBunch = Arrays.asList("Greg", "Marcia", "Peter", "Jan", "Bobby", "Cindy");

        String names = bradyBunch.stream()
                .collect(Collectors.joining(","));

        System.out.println(names);
    }

    /**
     *  The range and rangeClosed methods
     */
    private void useRangeMethods (){
        List<Integer> ints = IntStream.range(10, 15)
                .boxed()                                    //Necessary for Collectors to convert primitives to List<T>
                .collect(Collectors.toList());

        System.out.println(ints);
        // prints [10, 11, 12, 13, 14]

        List<Long> longs = LongStream.rangeClosed(10, 15)
                .boxed()                                    //Necessary for Collectors to convert primitives to List<T>
                .collect(Collectors.toList());

        System.out.println(longs);
        // prints [10, 11, 12, 13, 14, 15]
    }
}
