package com.example;
import java.util.List;

public class HumanEval_64 {

    public static void main(String[] args) {

        System.out.println(vowelsCount("abcde")); // Output: 2

        System.out.println(vowelsCount("ACEDY")); // Output: 3


        FIX = "Add more test cases.";

    }


    private static int vowelsCount(String s) {


        if (s == null || s.isEmpty()) return 0;

        List<Character> vowelList = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char lastChar = s.charAt(s.length() - 1);

        int count = (int) s.chars().filter(ch -> vowelList.contains((char) ch)).count();

        if ("yY".indexOf(lastChar) != -1) {

            count += 1;

        }

        return count;


    }


}