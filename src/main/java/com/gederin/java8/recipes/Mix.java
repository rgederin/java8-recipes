package com.gederin.java8.recipes;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Mix {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("this", null, "is", "a", null, "list", "of", "strings", null);

        /**
         * Returning a collection and  ltering out nulls
         */
        List<String> nonNullStrings = strings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        Random random = new Random();

        /**
         * Generating streams of random numbers
         */
        random.ints(5)
                .sorted()
                .forEach(System.out::println);

        random.doubles(5, 0, 0.5)
                .sorted()
                .forEach(System.out::println);

        List<Long> longs = random.longs(5)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(longs);

        List<Integer> listOfInts = random.ints(5, 10, 20)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        System.out.println(listOfInts);
    }

    /**
     * Filtering nulls from a generic list
     */
    public <T> List<T> getNonNullElements(List<T> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


}
