package com.example;
class Solution {
    /**
     * Determines if an object q will fly based on two conditions:
     * 1. It must be balanced (a palindrome).
     * 2. The sum of its elements must be less than or equal to the maximum possible weight w.
     * 
     * @param q The object (represented as an array of integers).
     * @param w The maximum possible weight.
     * @return True if the object will fly, False otherwise.
     */
    public static boolean willItFly(int[] q, int w) {
        // 1. Check if q is balanced (a palindrome)
        boolean isBalanced = true;
        int left = 0;
        int right = q.length - 1;
        while (left < right) {
            if (q[left] != q[right]) {
                isBalanced = false;
                break;
            }
            left++;
            right--;
        }

        // 2. Calculate the sum of elements in q
        long sumQ = 0;
        for (int element : q) {
            sumQ += element;
        }

        // 3. Check if the sum is within the weight limit
        boolean weightOk = sumQ <= w;

        // Return True only if both conditions are met
        return isBalanced && weightOk;
    }
}