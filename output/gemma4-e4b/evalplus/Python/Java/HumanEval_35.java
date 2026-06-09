package com.example;
import java.util.List;
import java.util.Collections;

class Solution {
    /**
     * Return maximum element in the list.
     * Note: This implementation assumes the list contains Double values 
     * to handle both integer and floating-point types robustly.
     * 
     * @param l The list of numbers.
     * @return The maximum element.
     * @throws IllegalArgumentException if the list is null or empty.
     */
    public double maxElement(List<Double> l) {
        if (l == null || l.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }
        return Collections.max(l);
    }
}