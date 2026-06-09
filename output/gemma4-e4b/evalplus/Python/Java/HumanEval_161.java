package com.example;
class Solution {
    public String solve(String s) {
        StringBuilder ans = new StringBuilder();
        boolean hasLetter = false;

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                hasLetter = true;
                char swappedChar = Character.toLowerCase(ch) == ch ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
                ans.append(swappedChar);
            } else {
                ans.append(ch);
            }
        }

        if (hasLetter) {
            return ans.toString();
        } else {
            return new StringBuilder(s).reverse().toString();
        }
    }
}