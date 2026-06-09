package com.example;
import java.util.List;

class Solution {

    /**
     * Calculates the strength of an extension string.
     * Strength = (Number of uppercase letters) - (Number of lowercase letters).
     */
    private int calculateStrength(String s) {
        int cap = 0;
        int sm = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                cap++;
            } else if (Character.isLowerCase(ch)) {
                sm++;
            }
        }
        return cap - sm;
    }

    /**
     * Finds the strongest extension based on the defined strength calculation.
     * If there is a tie, the extension appearing first in the list is chosen.
     * 
     * @param className The name of the class.
     * @param extensions A list of potential extension names.
     * @return The formatted string "ClassName.StrongestExtensionName".
     */
    public String strongestExtension(String className, List<String> extensions) {
        if (extensions == null || extensions.isEmpty()) {
            // Handle edge case where no extensions are provided
            return className + "."; // Or throw an exception, depending on expected behavior
        }

        int maxStrength = Integer.MIN_VALUE;
        String strongestExtension = null;

        for (String e : extensions) {
            int currentStrength = calculateStrength(e);

            // We use '>' comparison. If currentStrength == maxStrength, 
            // we ignore it, thus preserving the earlier found extension (the tiebreaker rule).
            if (currentStrength > maxStrength) {
                maxStrength = currentStrength;
                strongestExtension = e;
            }
        }

        // Since the problem guarantees extensions are provided (based on Python logic), 
        // strongestExtension should not be null here.
        return className + "." + strongestExtension;
    }
}