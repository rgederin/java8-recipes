package com.gederin.java8.recipes.interfaces;


/**
 * Functional interface with static and default methods
 */
@FunctionalInterface
public interface PalindromeChecker {
    boolean isPalidrome(String s);

    /**
     * The rules for functional interfaces say that methods from Object don’t count against the
     * single abstract method limit
     */
    String toString();

    default String sayHello() {
        return "Hello, World!";
    }

    static void myStaticMethod() {
        System.out.println("I'm a static method in an interface");
    }
}

/**
 * Extending a functional interface—no longer functional
 */
interface PalindromeCheckerChild extends PalindromeChecker {
    void check();
}