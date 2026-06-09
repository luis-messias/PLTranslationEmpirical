package com.example;
import java.util.Arrays;
import java.util.Collections;

public class HumanEval_94 {

    public static void main(String[] args) {
        // Test cases can be run here if needed.
    }

    private static boolean isPrime(int a) {
        return !((a < 2) || (Arrays.stream(new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97})
                .anyMatch(x -> a % x == 0));
    }

    public static int findLargestPrimeDigitSum(int[] lst) {
        Arrays.sort(lst);
        Collections.reverse(Arrays.asList(lst));

        for (int num : lst) {
            if (isPrime(num)) {
                return digitSumOfNumber(num);
            }
        }
        
        throw new IllegalArgumentException("No prime number found in the list.");
    }

    private static int digitSumOfNumber(int n) {
        String str = Integer.toString(n);
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += Character.getNumericValue(ch);
        }
        return sum;
    }
}