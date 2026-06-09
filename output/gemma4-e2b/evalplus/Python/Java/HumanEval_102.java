package com.example;
class Solution {
    public int choose_num(int x, int y) {
        if (x > y) {
            return -1;
        }

        // Find the largest even number less than or equal to y
        int largestEvenLeY;
        if (y % 2 ==