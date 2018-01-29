package com.gederin.java8.recipes;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ConstructorReference {

    /**
     * Transforming strings into Person instances
     */
    private static void constructorReference() {
        List<String> names =
                Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace",
                        "Karen Spärck Jones");

        //Using a lambda expression to invoke the constructor
        List<Person> people1 = names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        //Using a constructor reference instantiating Person
        List<Person> people2 = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    /**
     * Using the varargs constructor
     */
    private static void varargsConstructorReference(){
        List<String> names =
                Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace",
                        "Karen Spärck Jones");

        names.stream()
                .map(name -> name.split(" "))  // Map to a stream of string arrays
                .map(Person::new)              // Map to a stream of Person
                .collect(Collectors.toList()); // Collect to a list of Person

    }

    private static void arrayWithConstructorReference (){
        List<String> names =
                Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace",
                        "Karen Spärck Jones");

        Person[] people = names.stream()
                .map(Person::new)         // Constructor reference for Person
                .toArray(Person[]::new);  // Constructor reference for an array of Person
    }
}

@AllArgsConstructor
@Data
class Person {
    private String name;

    public Person(String... names) {
        name = Arrays.stream(names)
                .collect(Collectors.joining(" "));
    }
}