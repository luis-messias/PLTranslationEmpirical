package com.example;
public class HumanEval_80 {
    public static boolean isHappy(String s) {
        if (s.length() < 3) return false;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1) || s.charAt(i) == s.charAt(i + 2) || s.charAt(i + 1) == s.charAt(i + 2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy("a")); // False
        System.out.println(isHappy("aa")); // False
        System.out.println(isHappy("abcd")); // True
        System.out.println(isHappy("aabb")); // False
        System.out.println(isHappy("adb")); // True
        System.out.println(isHappy("xyy")); // False
    }
}