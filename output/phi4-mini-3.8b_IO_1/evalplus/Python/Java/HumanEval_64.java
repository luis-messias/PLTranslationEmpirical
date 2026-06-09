package com.example;

import java.util.List;
import java.util.Arrays;

public class HumanEval_64 {

    public static void main(String[] args) {
        System.out.println(vowelsCount("abcde")); // Output: 2

        System.out.println(vowelsCount("ACEDY")); // Output: 3
    }

    private static int vowelsCount(String s) {
        if (s == null || s.isEmpty()) return 0;

        List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char lastChar = Character.toLowerCase(s.charAt(s.length() - 1));

        int count = (int) s.chars().filter(ch -> vowelList.contains(Character.toLowerCase((char) ch))).count();

        if ("y".equals(lastChar)) {
            count += 1;
        }

        return count;
    }
}
