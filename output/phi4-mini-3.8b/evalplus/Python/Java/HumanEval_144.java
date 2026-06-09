package com.example;
public class HumanEval_144 {

    public static boolean simplify(String x, String n) {
        int[] fractionX = parseFraction(x);
        int[] fractionN = parseFraction(n);

        return (fractionX[0] * fractionN[0]) % ((fractionX[1] * fractionN[1])) == 0;
    }

    private static int[] parseFraction(String fractionStr) {
        String[] parts = fractionStr.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);

        return new int[]{numerator, denominator};
    }
}