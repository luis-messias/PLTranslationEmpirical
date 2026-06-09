package com.example;
import java.util.HashSet;
import java.util.Set;

class Result {
    String resultString;
    boolean isPalindrome;

    public Result(String resultString, boolean isPalindrome) {
        this.resultString = resultString;
        this.isPalindrome = isPalindrome;
    }
}

public class HumanEval_112 {
    /**
     * Deletes all characters in s that are equal to any character in c,
     * and checks if the resulting string is a palindrome.
     * @param s The source string.
     * @param c The characters to delete.
     * @return A Result object containing the resulting string and the palindrome check.
     */
    public Result reverseDelete(String s, String c) {
        // 1. Filter s: Build the resulting string ss
        StringBuilder sb = new StringBuilder();
        
        // Use a Set for efficient lookup of characters in c
        Set<Character> forbiddenChars = new HashSet<>();
        for (char ch : c.toCharArray()) {
            forbiddenChars.add(ch);
        }

        for (char ch : s.toCharArray()) {
            if (!forbiddenChars.contains(ch)) {
                sb.append(ch);
            }
        }
        String ss = sb.toString();

        // 2. Check for palindrome
        boolean isPalindrome = isPalindrome(ss);

        // 3. Return result
        return new Result(ss, isPalindrome);
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}