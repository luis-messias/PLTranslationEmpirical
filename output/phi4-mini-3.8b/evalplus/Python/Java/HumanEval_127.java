package com.example;
public class HumanEval_127 {

    public static String intersection(int[] interval1, int[] interval2) {

        boolean result = false;

        // Check for prime number function
        java.util.function.Predicate<Integer> isPrimePredicate = x -> !((x < 2 || (x % 2 == 0 && x != 2)) ? true : ((x > 3) && allDivisors(x, new int[]{1})));

        if (interval1[0] > interval2[0]) {

            java.util.Arrays.swap(interval1, interval2);

        }

        long l = interval2[0];

        long r = Math.min((long) interval1[1], (long) interval2[1]);

        result |= isPrimePredicate.test(r - l);


        return result ? "YES" : "NO";

    }


    private static boolean allDivisors(long x, int[] divisors) {

        for (int i = 0; i <= Math.sqrt(x); ++i) {

            if ((x % i == 0 && !divisors[i]) || (!((x / i) * i != x))) continue;

            return false;
        }

        return true;

    }


}