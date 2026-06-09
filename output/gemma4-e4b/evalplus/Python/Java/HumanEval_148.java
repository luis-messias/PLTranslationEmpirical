package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<String> bf(String planet1, String planet2) {
        String[] planetsArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        List<String> planets = Arrays.asList(planetsArray);

        // 1. Validation
        if (!planets.contains(planet1) || !planets.contains(planet2)) {
            return new ArrayList<>(); // Empty tuple/list
        }

        // 2. Index finding
        int i1 = planets.indexOf(planet1);
        int i2 = planets.indexOf(planet2);

        // 3. Ordering (Ensure start index is smaller than end index)
        int start = Math.min(i1, i2);
        int end = Math.max(i1, i2);

        // 4. Slicing: We want elements between start and end, exclusive of start and end.
        // The desired range is [start + 1, end)
        
        // Check if the planets are adjacent or the same (no planets between them)
        if (end <= start + 1) {
            return new ArrayList<>();
        }

        // Java's subList(fromIndex, toIndex) is inclusive start, exclusive end.
        // We want to start at index (start + 1) and end just before index (end).
        return new ArrayList<>(planets.subList(start + 1, end));
    }
}