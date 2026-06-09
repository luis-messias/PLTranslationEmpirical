package com.example;
import java.util.Arrays;

public class HumanEval_86 {

    public static String anti_shuffle(String s) {
        if (s == null || s.isEmpty()) return "";

        char[] chars = s.toCharArray();
        Arrays.sort(chars, Comparator.comparingInt(ch -> Character.digit((char) ch, 16)));
        
        int start = 0;
        while ((start = s.indexOf(' ', start)) != -1) {
            String word = new String(Arrays.copyOfRange(chars, start + 1, chars.length));
            Arrays.sort(word.toCharArray(), Comparator.comparingInt(ch -> Character.digit((char) ch, 16)));
            for (int i = 0; i < word.length(); i++) {
                char temp = word.charAt(i);
                s = s.substring(0, start + 1) + new String(Arrays.copyOfRange(word.toCharArray(), i + 1)) 
                    + Character.toString(temp) + " ";
            }
        }

        return s.trim();
    }

    public static void main(String[] args) {
        System.out.println(anti_shuffle("Hi")); // Hi
        System.out.println(anti_shuffle("hello")); // ehllo
        System.out.println(anti_shuffle("Hello World!!!")); // Hello !!!Wdlor
    }
}
