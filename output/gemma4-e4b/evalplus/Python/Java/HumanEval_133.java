package com.example;
class Solution {
    /**
     * Calculates the sum of squares of the ceiling of each number in the list.
     * @param lst The input array of numbers.
     * @return The sum of the squared ceiling values.
     */
    public long sumSquares(double[] lst) {
        long sum = 0;
        for (double x : lst) {
            // Calculate the ceiling of x
            double ceilingDouble = Math.ceil(x);
            
            // Cast the ceiling value to long since it represents an integer
            long ceilingLong = (long) ceilingDouble;
            
            // Square the ceiling value and add to the sum
            long square = ceilingLong * ceilingLong;
            sum += square;
        }
        return sum;
    }
}