package com.example;
import java.util.Arrays;

public class HumanEval_148 {
    public static String[] bf(String planet1, String planet2) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        if (!Arrays.asList(planets).contains(planet1) || !Arrays.asList(planets).contains(planet2)) return new String[0];
        int i1 = Arrays.asList(planets).indexOf(planet1), i2 = Arrays.asList(planets).indexOf(planet2);
        if (i1 > i2) { i1 = i2; i2 = i1; }
        String[] result = new String[i2 - i1 - 1];
        System.arraycopy(planets, i1 + 1, result, 0, i2 - i1 - 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bf("Jupiter", "Neptune")));
        System.out.println(Arrays.toString(bf("Earth", "Mercury")));
        System.out.println(Arrays.toString(bf("Mercury", "Uranus")));
    }
}