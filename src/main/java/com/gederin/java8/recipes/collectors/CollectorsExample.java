package com.gederin.java8.recipes.collectors;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CollectorsExample {
    public static void main(String[] args) {

        /**
         Creating a List (ArrayList)
         */
        List<String> superHeroes = Stream.of("Mr. Furious", "The Blue Raja", "The Shoveler",
                "The Bowler", "Invisible Boy", "The Spleen", "The Sphinx")
                .collect(Collectors.toList());

        /**
         * Creating Set (HashSet)
         */
        Set<String> villains = Stream.of("Casanova Frankenstein", "The Disco Boys",
                "The Not-So-Goodie Mob", "The Suits", "The Suzies",
                "The Furriers", "The Furriers")
                .collect(Collectors.toSet());

        /**
         * Creating a linked list
         */
        List<String> actorsList = Stream.of("Hank Azaria", "Janeane Garofalo", "William H. Macy",
                "Paul Reubens", "Ben Stiller", "Kel Mitchell", "Wes Studi")
                .collect(Collectors.toCollection(LinkedList::new));

        /**
         * Creating array
         */
        String[] wannabes = Stream.of("The Waffler", "Reverse Psychologist", "PMS Avenger")
                .toArray(String[]::new);


        Set<Actor> actors = new HashSet<>();

        actors.add(new Actor("Ruslan", "Batman"));
        actors.add(new Actor("Gederin", "Spiderman"));

        /**
         * Creating a Map
         */
        Map<String, String> actorMap = actors.stream()
                .collect(Collectors.toMap(Actor::getName, Actor::getRole));

        actorMap.forEach((key, value) ->
                System.out.printf("%s played %s%n", key, value));
    }
}

@Data
@AllArgsConstructor
class Actor {
    private String name;
    private String role;
}