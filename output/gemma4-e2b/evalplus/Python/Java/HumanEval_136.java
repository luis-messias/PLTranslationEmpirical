package com.example;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HumanEval_136 {

    /**
     * Create a function that returns an array [a, b], where 'a' is
     * the largest of negative integers, and 'b' is the smallest
     * of positive integers in a list.
     * If there is no negative or positive integers, return null for them.
     *
     * @param lst The input list of integers.
     * @return An array of two Integers: [largest_negative, smallest_positive].
     *         Returns null for a component if no corresponding numbers exist.
     */
    public static Integer[] largestSmallestIntegers(List<Integer> lst) {
        // 1. Find negative integers
        List<Integer> neg = lst.stream()
                               .filter(x -> x < 0)
                               .collect(Collectors.toList());

        // 2. Find positive integers
        List<Integer> pos = lst.stream()
                               .filter(x -> x > 0)
                               .collect(Collectors.toList());

        Integer largestNegative = null;
        if (!neg.isEmpty()) {
            // Find the maximum among negative numbers
            largestNegative = Collections.max(neg);
        }

        Integer smallestPositive = null;
        if (!pos.isEmpty()) {
            // Find the minimum among positive numbers
            smallestPositive = Collections.min(pos);
        }

        // Return the result as