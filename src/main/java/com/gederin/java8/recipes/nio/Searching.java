package com.gederin.java8.recipes.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class Searching {

    public static void main(String[] args) {

        /**
         * Finding the nondirectory files in the nio package
         */
        try (Stream<Path> paths = Files.find(Paths.get("src/main/java"), Integer.MAX_VALUE,
                (path, attributes) ->
                        !attributes.isDirectory() && path.toString().contains("nio"))) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
