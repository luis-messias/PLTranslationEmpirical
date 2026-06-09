package com.example;
class Solution {
    /**
     * Compares two variables (which can be various types representing real numbers)
     * and returns the larger one in its original type, or null if they are equal.
     *
     * @param a The first variable.
     * @param b The second variable.
     * @return The larger variable (Object), or null if equal.
     */
    public Object compareOne(Object a, Object b) {
        double numA = getDoubleValue(a);
        double numB = getDoubleValue(b);

        // Check for equality
        if (numA == numB) {
            return null;
        }

        // Return the larger variable in its original type
        if (numA > numB) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Helper method to convert an Object (which might be String, Integer, Double, etc.)
     * into a comparable double value, handling both comma and dot decimal separators.
     */
    private double getDoubleValue(Object obj) {
        // Convert the object to a string representation
        String s = String.valueOf(obj);
        
        // Replace comma with dot for standard Java/Python double parsing
        s = s.replace(",", ".");
        
        // Parse the string to double
        return Double.parseDouble(s);
    }
}