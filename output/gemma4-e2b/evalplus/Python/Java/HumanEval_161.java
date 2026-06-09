package com.example;
class Solution {
    public String solve(String s) {
        StringBuilder ans = new StringBuilder();
        boolean hasLetter = false;

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                hasLetter = true;
                if (Character.isLowerCase(ch)) {
                    ans.append(Character.toUpperCase(ch));
                } else {
                    ans.append(Character.toLowerCase(ch));
                }
            } else {
                ans.append(ch);
            }
        }

        if (!hasLetter) {
            // If the string contains no letters, reverse the string.
            return new StringBuilder(s).reverse().toString();
        } else {
            return ans.toString();
        }
    }
}