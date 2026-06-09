package com.example;
class Solution {
    public String file_name_check(String fileName) {
        // 1. Check for maximum three digits
        int digitCount = 0;
        for (char c : fileName.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        if (digitCount > 3) {
            return "No";
        }

        // 2. Check for exactly one dot and split the name
        // Using split("\\.", -1) ensures that if the file name ends with a dot, 
        // the resulting array length is correct for the number of segments.
        String[] parts = fileName.split("\\.", -1);

        if (parts.length != 2) {
            return "No";
        }

        String namePart = parts[0];
        String extensionPart = parts[1];

        // 3. Check the name part (before the dot)
        // Must not be empty
        if (namePart.isEmpty()) {
            return "No";
        }
        
        // Must start with a letter
        if (!Character.isLetter(namePart.charAt(0))) {
            return "No";
        }

        // 4. Check the extension part (after the dot)
        String[] allowedExtensions = {"txt", "exe", "dll"};
        boolean extensionValid = false;
        for (String ext : allowedExtensions) {
            if (ext.equals(extensionPart)) {
                extensionValid = true;
                break;
            }
        }

        if (!extensionValid) {
            return "No";
        }

        // All conditions met
        return "Yes";
    }
}