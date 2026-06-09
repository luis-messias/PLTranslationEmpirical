package com.example;

public class HumanEval_107 {

    public static int[] countEvenOddPalindromes(int n) {
        if (n < 1 || n > 1000) { // Check range constraint is met.
            throw new IllegalArgumentException("Input must be between 1 and 1000.");
        }

        String strN = Integer.toString(n);
        int lenStrN = strN.length();
        boolean[] evenOddCounts = new boolean[2]; // Index 0 for odds, index 1 for evens

        if (lenStrN % 2 == 1) {
            char middleChar = strN.charAt(lenStrN / 2);
            StringBuilder leftHalf = new StringBuilder(strN.substring(0, lenStrN / 2));
            String rightHalf = strN.substring(lenStrN - lenStrN / 2);

            if (!leftHalf.toString().equals(rightHalf.reverse())) {
                return new int[]{1}; // Only the middle character can be a palindrome
            }
        }

        for (int i = 0; i < Math.pow(10, lenStrN); i++) {

            StringBuilder sb = new StringBuilder(strN);
            boolean isPalindrome;

            if ((lenStrN % 2 == 1) && Integer.parseInt(sb.reverse().toString()) != n) {
                continue;
            }

            for (int j = Math.max(0, lenStrN - 1); j >= 0; --j) {

                int numToAdd = Character.getNumericValue(String.valueOf(i / Math.pow(10, lenStrN-j-1)));
                sb.setCharAt(j, (char)(sb.charAt(j)+numToAdd));

            }

            isPalindrome = strN.equals(sb.toString());

            if (!isPalindrome) {
                continue;
            }

            int num = Integer.parseInt(strN);
            evenOddCounts[num % 2]++;

        }
        
        return new int[]{evenOddCounts[1], evenOddCounts[0]};
    }
}
