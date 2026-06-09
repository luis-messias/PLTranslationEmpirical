package com.example;
class Solution {
    public static int fizzBuzz(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i % 11 == 0 || i % 13 == 0) {
                String s = String.valueOf(i);
                int currentCount = 0;
                for (char c : s.toCharArray()) {
                    if (c == '7') {
                        currentCount++;
                    }
                }
                count += currentCount;
            }
        }
        return count;
    }
}