package com.example;
import java.util.ArrayList;

public class HumanEval_148 {

    public static void main(String[] args) {
        System.out.println(bf("Jupiter", "Neptune"));
        System.out.println(bf("Earth", "Mercury"));
        System.out.println(bf("Mercury", "Uranus"));
    }

    private static String bf(String planet1, String planet2) {
        ArrayList<String> planets = new ArrayList<>();
        planets.addAll(Arrays.asList(
                "Mercury",
                "Venus",
                "Earth",
                "Mars",
                "Jupiter",
                "Saturn",
                "Uranus",
                "Neptune"
        ));

        if (!planets.contains(planet1) || !planets.contains(planet2)) {
            return "";
        }

        int i1 = planets.indexOf(planet1);
        int i2 = planets.indexOf(planet2);

        if (i1 > i2) {
            int temp = i1;
            i1 = i2;
            i2 = temp;
        }

        ArrayList<String> result = new ArrayList<>(planets.subList(i1 + 1, i2));
        
        Collections.sort(result);
        
        return String.join(",", result);
    }
}
