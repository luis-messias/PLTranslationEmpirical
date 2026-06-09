package com.example;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    /**
     * Return a string containing space-delimited numbers starting from 0 upto n inclusive.
     * @param n The upper bound (inclusive).
     * @return The space-delimited string of numbers.
     */
    public static String stringSequence(int n) {
        return IntStream.rangeClosed(0, n)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
    }
}