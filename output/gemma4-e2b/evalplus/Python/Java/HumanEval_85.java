package com.example;
class Solution {
    public static int add(int[] lst) {
        int s = 0;
        // Iterate over odd indices: 1, 3, 5, ...
        for (int i = 1; i < lst.length; i += 2) {
            // Check if the element at the odd index is even
            if (lst[i] % 2 == 0) {
                s += lst[i];
            }
        }
        return s;
    }
}