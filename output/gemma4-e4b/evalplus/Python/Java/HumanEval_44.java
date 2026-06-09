package com.example;
class Solution {
    /**
     * Change numerical base of input number x to base.
     * Returns string representation after the conversion.
     * base numbers are less than 10.
     */
    public String changeBase(int x, int base) {
        if (x == 0) {
            return "0";
        }

        StringBuilder ret = new StringBuilder();
        int currentX = x;

        while (currentX != 0) {
            int remainder = currentX % base;
            // Prepend the remainder (as a digit)
            ret.insert(0, remainder);
            currentX /= base;
        }
        return ret.toString();
    }
}