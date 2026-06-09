package com.example;
class Solution {
    /**
     * Converts a decimal number to its binary string representation,
     * wrapped with "db" at the beginning and end.
     *
     * @param decimal The decimal number to convert.
     * @return A string in the format "db[binary_representation]db".
     */
    public String decimalToBinary(int decimal) {
        // Integer.toBinaryString(decimal) converts the integer to its binary string representation.
        // We prepend and append "db" as required by the problem description.
        return "db" + Integer.toBinaryString(decimal) + "db";
    }
}