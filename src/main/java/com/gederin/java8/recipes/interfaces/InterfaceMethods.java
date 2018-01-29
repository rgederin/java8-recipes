package com.gederin.java8.recipes.interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InterfaceMethods {

    /**
     * Using default methods
     */
    private static void useDefaultInterfaceMethod() {
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9);

        //Use the default method removeIf from Collection
        boolean removed = nums.removeIf(n -> n <= 0);

        //Use the default method forEach from Iterator
        System.out.println("Elements were " + (removed ? "" : "NOT") + " removed");
        nums.forEach(System.out::println);
    }

    private static void useStaticInterfaceMethod() {
        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore",
                "Dalton", "Brosnan", "Craig");

        // [Brosnan, Connery, Craig, Dalton, Lazenby, Moore]
        List<String> sorted = bonds.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        // [Moore, Lazenby, Dalton, Craig, Connery, Brosnan]
        sorted = bonds.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // [Brosnan, Connery, Craig, Dalton, Lazenby, Moore]
        sorted = bonds.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());

        // [Moore, Craig, Dalton, Connery, Lazenby, Brosnan]
        sorted = bonds.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());


        // [Craig, Moore, Dalton, Brosnan, Connery, Lazenby]
        sorted = bonds.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

    }
}
