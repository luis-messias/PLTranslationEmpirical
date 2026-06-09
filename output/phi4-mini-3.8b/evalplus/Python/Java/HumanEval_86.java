package com.example;
import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_86 {

    public static String anti_shuffle(String s) {
        if (s == null || s.isEmpty()) return "";

        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars, Comparator.comparingInt(ch -> Character.digit(ch, 16)));
            words[i] = new String(chars);
        }
        
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(anti_shuffle("Hi")); // Hi
        System.out.println(anti_shuffle("hello")); // ehllo
        System.out.println(anti_shuffle("Hello World!!!")); // Hello !!!Wdlor
    }
}