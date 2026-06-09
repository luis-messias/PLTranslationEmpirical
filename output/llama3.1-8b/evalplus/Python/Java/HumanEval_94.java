package com.example;
import java.util.Arrays;

public class HumanEval_94 {
    public static void main(String[] args) {
        System.out.println(skjkasdkd(new Integer[]{0, 3, 2, 1, 3, 5, 7, 4, 5, 5, 5, 2, 181, 32, 4, 32, 3, 2, 32, 324, 4, 3}));
        System.out.println(skjkasdkd(new Integer[]{1, 0, 1, 8, 2, 4597, 2, 1, 3, 40, 1, 2, 1, 2, 4, 2, 5, 1}));
        System.out.println(skjkasdkd(new Integer[]{1, 3, 1, 32, 5107, 34, 83278, 109, 163, 23, 2323, 32, 30, 1, 9, 3}));
        System.out.println(skjkasdkd(new Integer[]{0, 724, 32, 71, 99, 32, 6, 0, 5, 91, 83, 0, 5, 6}));
        System.out.println(skjkasdkd(new Integer[]{0, 81, 12, 3, 1, 21}));
        System.out.println(skjkasdkd(new Integer[]{0, 8, 1, 2, 1, 7}));
    }

    public static int skjkasdkd(Integer[] lst) {
        return largestPrimeDigitSum(lst);
    }

    private static boolean isPrime(int a) {
        if (a < 2) return false;
        for (int x = 2; x <= Math.sqrt(a); x++) {
            if (a % x == 0) return false;
        }
        return true;
    }

    private static int largestPrimeDigitSum(Integer[] lst) {
        Arrays.sort(lst);
        for (Integer x : lst) {
            if (isPrime(x)) return sumOfDigits(x);
        }
        return -1; // Return a default value to indicate no prime found
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}