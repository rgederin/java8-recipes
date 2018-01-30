package com.gederin.java8.recipes.streams;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedStreams {
    /**
     * Using the boxed method
     */
    private static void useBoxed() {
        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Using the mapToObj method
     */
    private static void useMapToObj() {
        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    /**
     * Using the three-argument version of collect
     */
    private static void usingThreeArgumentCollect (){
        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
    }

    /**
     * Convert an IntStream to an int array
     */
    private static void convertIntStreamToArray(){
        int[] intArray = IntStream.of(3, 1, 4, 1, 5, 9).toArray();
    }
}
