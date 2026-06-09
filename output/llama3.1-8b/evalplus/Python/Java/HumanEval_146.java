package com.example;
import java.util.Arrays;

public class HumanEval_146 {
    public static int specialFilter(int[] nums) {
        int count = 0;
        String[] oddDigits = {"1", "3", "5", "7", "9"};
        for (int num : nums) {
            if (num > 10 && Arrays.asList(oddDigits).contains(String.valueOf(num).substring(0, 1)) 
                && Arrays.asList(oddDigits).contains(String.valueOf(num).substring(String.valueOf(num).length() - 1))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {15, -73, 14, -15};
        System.out.println(specialFilter(nums));
        
        int[] nums2 = {33, -2, -3, 45, 21, 109};
        System.out.println(specialFilter(nums2));
    }
}