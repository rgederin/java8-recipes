package com.gederin.java8.recipes.function;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * IntConsumer          void accept(int x)
 * DoubleConsumer       void accept(double x)
 * LongConsumer         void accept(long x)
 * BiConsumer           void accept(T t, U u)
 * ObjIntConsumer       void accept(T t, int x)
 * ObjLongConsumer      void accept(T t, long x)
 * ObjDoubleConsumer    void accept(T t, double x)
 */
public class Consumers {
    private static void useConsumers() {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        //Anonymous inner class implementation
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //Expression lambda
        strings.forEach(s -> System.out.println(s));

        //Method reference
        strings.forEach(System.out::println);
    }
}
