package com.example;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HumanEval_19 {

    /**
     * Input is a space-delimited string of numberals from 'zero' to 'nine'.
     * Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
     * Return the string with numbers sorted from smallest to largest
     *
     * @param numbers The space-delimited string of number names.
     * @return The sorted space-delimited string.
     */
    public static String sortNumbers(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            return "";
        }

        Map<String, Integer> toInt = new HashMap<>();
        toInt.put("zero", 0);
        toInt.put("one", 1);
        toInt.put("two", 2);
        toInt.put("three", 3);
        toInt.put("four", 4);
        toInt.put("five", 5);
        toInt.put("six", 6);
        toInt.put("seven", 7);
        toInt.put("eight", 8);
        toInt.put("nine", 9);

        // Split the string by one or more spaces to handle potential extra spaces
        String[] parts = numbers.trim().split("\\s+");

        // Sort the array using a custom Comparator based on the integer value
        Arrays.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // We assume all input parts are valid keys in toInt based on the problem description
                return Integer.compare(toInt.get(s1), toInt.get(s2));
            }
        });

        // Join the sorted array elements back into a space-delimited string
        return String.join(" ", parts);
    }
}