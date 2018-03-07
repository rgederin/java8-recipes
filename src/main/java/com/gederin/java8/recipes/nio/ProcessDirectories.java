package com.gederin.java8.recipes.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ProcessDirectories {
    public static void main(String[] args) {
        /**
         * Using Files.list(path)
         */
        try (Stream<Path> list = Files.list(Paths.get("src/main/java/com/gederin/java8/recipes"))) {
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
