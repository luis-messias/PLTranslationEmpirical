package com.example;
public class HumanEval_107 {

    public static int[] countEvenOddPalindromes(int n) {

        int[] counts = new int[2]; // Index 0 for odds, index 1 for evens

        String strN;

        if (n < 10 || n > 9999) { // Check the range constraint is met.

            throw new IllegalArgumentException("Input must be between 1 and 10000.");

        }

        strN = Integer.toString(n);

        int lenStrN = strN.length();

        for (int i = 0; i < Math.pow(10, lenStrN); i++) {

            StringBuilder sb = new StringBuilder(strN);
            boolean isPalindrome;

            if ((lenStrN % 2 == 1) && i != Integer.parseInt(sb.reverse().toString())) {
                continue;
            }

            for (int j = Math.max(0, lenStrN - 1); j >= 0; --j) {

                int numToAdd = String.valueOf(i / Math.pow(10, lenStrN-j-1)).charAt(String.valueOf(i % Math.pow(10, lenStrN-j-1)));

                sb.setCharAt(j, (char)(sb.charAt(j)+numToAdd));

            }

            isPalindrome = strN.equals(sb.toString());

            if (!isPalindrome) {

                continue;

            }

            int num = Integer.parseInt(strN);

            counts[num % 2]++;

        }


        return new int[]{counts[1], counts[0]};
    }



}