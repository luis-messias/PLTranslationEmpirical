package com.example;
class Solution {
    public static int solution(int[] lst) {
        int sum = 0;
        for (int i = 0; i < lst.length; i++) {
            // Check if the index is even (even position)
            // and the element is odd
            if (i % 2 == 0 && lst[i] % 2 != 0) {
                sum += lst[i];
            }
        }
        return sum;
    }
}