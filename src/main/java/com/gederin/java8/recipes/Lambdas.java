package com.gederin.java8.recipes;


import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Lambdas {


    /**
     * Anonymous inner class implementation of Runnable
     */
    private static void traditionalRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable using an anonymous inner class");
            }
        }).start();
    }

    /**
     * Using a lambda expression in a  read constructor
     */
    private static void lambdaRunnable() {
        new Thread(() -> System.out.println(
                "inside Thread constructor using lambda")).start();
    }

    /**
     * Assigning a lambda expression to a variable
     */
    private static void lambdaToVariable() {
        Runnable r = () -> System.out.println(
                "lambda expression implementing the run method");
        new Thread(r).start();
    }

    /**
     * An anonymous inner class implementation of FilenameFilter
     */
    private static void traditionalFileFilter() {
        File directory = new File("./src/main/java");

        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        System.out.println(Arrays.asList(names));
    }

    /**
     * Lambda expression implementing FilenameFilter
     */
    private static void lambdaFileFilter() {
        File directory = new File("./src/main/java");

        String[] names = directory.list((dir, name) -> name.endsWith(".java"));

        System.out.println(Arrays.asList(names));
    }

    /**
     * Lambda expression with explicit data types
     */
    private static void explicitLambdaParameters() {
        File directory = new File("./src/main/java");

        String[] names = directory.list((File dir, String name) -> name.endsWith(".java"));
    }

    /**
     * A block lambda
     */
    private static void blockLambda() {
        File directory = new File("./src/main/java");

        String[] names = directory.list((File dir, String name) -> {
            return name.endsWith(".java");
        });

        System.out.println(Arrays.asList(names));
    }
}
