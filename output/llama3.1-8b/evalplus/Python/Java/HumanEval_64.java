package com.example;
public class HumanEval_64 {
    public static String FIX = """
Add more test cases.
""";

    public static int vowelsCount(String s) {
        if (s.isEmpty()) return 0;
        int cnt = s.chars().filter(ch -> "aeiouAEIOU".indexOf(ch) != -1).count();
        if (s.charAt(s.length() - 1) == 'y' || s.charAt(s.length() - 1) == 'Y') {
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(vowelsCount("abcde")); // prints: 2
        System.out.println(vowelsCount("ACEDY")); // prints: 3
    }
}