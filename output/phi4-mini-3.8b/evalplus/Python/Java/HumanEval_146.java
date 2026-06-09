package com.example;
public class HumanEval_146 {

    public static int specialFilter(int[] nums) {

        String[] odd = {"1", "3", "5", "7", "9"};

        int count = 0;

        for (int num : nums) {
            if (num > 10 && isOdd(num / 10000) && isOdd(num % 100000)) { // Extracting first and last digits

                count++;

            }

        }

        return count;
    }


    private static boolean isOdd(int digit) {

        String strDigit = Integer.toString(digit);

        for (String odd : odd) {

            if (strDigit.equals(odd)) {

                return true;

            }

        }

        return false;

    }


    public static void main(String[] args) {

        int[] nums1 = {15, -73, 14, -15};

        System.out.println(specialFilter(nums1)); // Output: 1

        int[] nums2 = {33, -2, -3, 45, 21, 109};

        System.out.println(specialFilter(nums2)); // Output: 2

    }

}