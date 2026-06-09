package com.example;
import java.util.regex.Pattern;

public class HumanEval_125 {
    public static Object splitWords(String txt) {
        String[] whitespace = {" ", "\n", "\r", "\t"};
        if (Pattern.compile("\\s").matcher(txt).find()) return txt.split("\\s+");
        if (txt.contains(",")) return txt.split(",");
        int cnt = 0;
        for (char ch : txt.toCharArray()) {
            if (Character.isLowerCase(ch) && ((ch - 'a') % 2 == 1)) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(splitWords("Hello world!"));
        System.out.println(splitWords("Hello,world!"));
        System.out.println(splitWords("abcdef"));
    }
}