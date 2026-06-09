package com.example;

public class HumanEval_77 {

    public static boolean isCube(int a) {
        long absoluteValue = Math.abs(a);

        double cubeRoot = round(absoluteValue, (int)(Math.log10(Math.sqrt(absoluteValue)) / 3));

        return (cubeRoot * cubeRoot * cubeRoot == absoluteValue);
    }

    private static int round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        double scale = Math.pow(10, places);

        long scaledNumber = ((long)(Math.round(value * scale))) / scale;

        return (int)scaledNumber;
    }
}
