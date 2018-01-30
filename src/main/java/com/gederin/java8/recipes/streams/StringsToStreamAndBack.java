package com.gederin.java8.recipes.streams;


public class StringsToStreamAndBack {

    /**
     * Checking for palindromes in Java 7 or earlier
     */
    public boolean java7isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        String forward = sb.toString().toLowerCase();
        String backward = sb.reverse().toString().toLowerCase();

        return forward.equals(backward);
    }

    /**
     * Checking for palindromes using Java 8 streams
     */
    public boolean java8IsPalindrome(String s) {
        String forward = s.toLowerCase().codePoints()
                .filter(Character::isLetterOrDigit).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        String backward = new StringBuilder(forward).reverse().toString();

        return forward.equals(backward);
    }
}
