package com.example;
import java.util.Arrays;

public class HumanEval_114 {
    public static int minSubArraySum(int[] nums) {
        if (Arrays.stream(nums).allMatch(x -> x >= 0)) {
            return Arrays.stream(nums).min().getAsInt();
        }
        int s = 0, ans = Integer.MAX_VALUE;
        for (int x : nums) {
            s += x;
            ans = Math.min(ans, s);
            if (s >= 0) s = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 1, 2, 4};
        System.out.println(minSubArraySum(nums1)); // prints: 1

        int[] nums2 = {-1, -2, -3};
        System.out.println(minSubArraySum(nums2)); // prints: -6
    }
}