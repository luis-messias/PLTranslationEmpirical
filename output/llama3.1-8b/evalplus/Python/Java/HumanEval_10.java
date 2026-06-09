package com.example;
public class HumanEval_10 {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static String makePalindrome(String s) {
        if (isPalindrome(s)) return s;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) {
                StringBuilder sb = new StringBuilder(s);
                sb.append(sb.reverse().toString().substring(0, i));
                return sb.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(makePalindrome(""));
        System.out.println(makePalindrome("cat"));
        System.out.println(makePalindrome("cata"));
    }
}