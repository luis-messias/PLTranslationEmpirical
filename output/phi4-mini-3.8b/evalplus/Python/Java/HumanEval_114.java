package com.example;
import java.util.Arrays;

public class HumanEval_114 {

    public static int findMin(int[] nums) {

        boolean allNonNegative = true;

        for (int num : nums) {

            if (num < 0) {

                allNonNegative = false;

                break;

            }

        }


        // If the array contains only non-negative numbers, return minimum element

        if (allNonNegative) {

            int minElement = Arrays.stream(nums).min().getAsInt();

            return minElement;

        }


        long s = 0; // Using 'long' to avoid overflow for large sums

        int ans = Integer.MAX_VALUE;


        for (int x : nums) {

            s += x;

            if (s < ans) {

                ans = (int)s;

            }

            if (s >= 0) { // Reset sum only when it is non-negative, as per original logic

                s = 0;

            }

        }


        return ans == Integer.MAX_VALUE ? -1 : ans; // Return -1 or the minimum found value


    }


    public static void main(String[] args) {

        int[] nums1 = {2, 3, 4, 1, 2, 4};

        System.out.println(findMin(nums1)); // Output: 1

        int[] nums2 = {-1, -2, -3};

        System.out.println(findMin(nums2)); // Output: -6

    }

}