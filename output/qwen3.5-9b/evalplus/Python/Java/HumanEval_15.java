package com.example;
public static String stringSequence(int n) {
    /** Return a string containing space-delimited numbers starting from 0 upto n inclusive.
     * @param n the upper bound (inclusive)
     * @return space-delimited string of numbers from 0 to n
     */
    return IntStream.rangeClosed(0, n)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
}