package com.example;
import java.util.List;
import java.util.AbstractMap;
import java.util.Map;

public class HumanEval_8 {
    /**
     * For a given list of integers, return a tuple consisting of a sum and a product of all the integers in a list.
     * Empty sum should be equal to 0 and empty product should be equal to 1.
     *
     * @param numbers The list of integers.
     * @return A Map containing the sum and the product.
     */
    public static Map.Entry<Integer, Integer> sumProduct(List<Integer> numbers) {
        int sum = 0;
        int product = 1;

        for (int number : numbers) {
            sum += number;
            product *= number;
        }

        // Using AbstractMap.SimpleEntry to simulate a tuple return type
        return new AbstractMap.SimpleEntry<>(sum, product);
    }

    public static void main(String[] args) {
        // Example usage (optional, for testing)
        System.out.println(sumProduct(List.of())); // Expected: (0, 1)
        System.out.println(sumProduct(List.of(1, 2, 3, 4))); // Expected: (10, 24)
    }
}