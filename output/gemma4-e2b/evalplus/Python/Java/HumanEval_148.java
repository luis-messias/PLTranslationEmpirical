package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PlanetFinder {
    public static List<String> bf(String planet1, String planet2) {
        List<String> planets = Arrays.asList(
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
        );

        if (!planets.contains(planet1) || !planets.contains(planet2)) {
            return new ArrayList<>();
        }

        int i1 = planets.indexOf(planet1);
        int i2 = planets.indexOf(planet2);

        // Ensure i1 is the smaller index
        if (i1 > i2) {
            int temp = i1;
            i1 = i2;
            i2 = temp;
        }

        List<String> result = new ArrayList<>();
        // Extract planets strictly between i1 and i2
        for (int i = i1 + 1; i < i2; i++) {
            result.add(planets.get(i));
        }

        return result;
    }
}