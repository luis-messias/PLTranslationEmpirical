package com.example;

import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_145 {
    public static int[] order_by_points(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    private static Comparator<Integer> weightComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer x, Integer y) {
            int weightX = getWeight(x);
            int weightY = getWeight(y);
            if (weightX != weightY) return weightX - weightY;
            else return x - y;
        }
    };

    private static int getWeight(int num) {
        String strNum = Integer.toString(Math.abs(num));
        int sum = 0;
        for (char c : strNum.toCharArray()) {
            sum += c - '0';
        }
        if (num < 0) sum = -sum;
        return sum;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 11, -1, -11, -12};
        System.out.println(Arrays.toString(order_by_points(nums1)));
        
        int[] nums2 = {};
        System.out.println(Arrays.toString(order_by_points(nums2)));
    }
}
