package com.example;
class Solution {
    public int chooseNum(int x, int y) {
        if (x > y) {
            return -1;
        }
        if (x == y) {
            return (y % 2 == 0) ? y : -1;
        }
        // x < y
        return (y % 2 == 0) ? y : y - 1;
    }
}