package com.example;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Solution {

    /**
     * Checks if a number is prime.
     * @param a The number to check.
     * @return true if a is prime, false otherwise.
     */
    private static boolean isPrime(int a) {
        if (a < 2) return false;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the sum of the digits of a number.
     * @param n The number.
     * @return The sum of its digits.
     */
    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Finds the largest prime value in the list and returns the sum of its digits.
     * @param lst The list of integers.
     * @return The sum of digits of the largest prime found.
     */
    public static int skjkasdkd(List<Integer> lst) {
        // Create a mutable copy and sort it in descending order
        List<Integer> sortedList = new ArrayList<>(lst);
        sortedList.sort(Comparator.reverseOrder());

        for (int x : sortedList) {
            if (isPrime(x)) {
                // Found the largest prime, return the sum of its digits
                return sumOfDigits(x);
            }
        }
        // If no prime is found (though examples suggest one always exists)
        return 0;
    }
}