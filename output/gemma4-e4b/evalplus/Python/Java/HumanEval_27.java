package com.example;
class Solution {
    /**
     * For a given string, flip lowercase characters to uppercase and uppercase to lowercase.
     * @param str The input string.
     * @return The string with flipped case.
     */
    public String flipCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}