package com.example;
public class HumanEval_153 {
    public static String strongestExtension(String className, String[] extensions) {
        int maxStrength = Integer.MIN_VALUE;
        String strongestExtension = "";

        for (String extension : extensions) {
            int strength = calculateStrength(extension);
            if (strength > maxStrength) {
                maxStrength = strength;
                strongestExtension = extension;
            }
        }

        return className + "." + strongestExtension;
    }

    private static int calculateStrength(String s) {
        int cap = 0, sm = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) cap++;
            else if (Character.isLowerCase(ch)) sm++;
        }
        return cap - sm;
    }
}