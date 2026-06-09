package com.example;
import java.util.stream.Collectors;

public class HumanEval_51 {

    public static String remove_vowels(String text) {
        if (text == null || text.isEmpty()) return "";
        
        return text.chars()
                .filter(ch -> "aeiouAEIOU".indexOf((char) ch) < 0)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(remove_vowels(""));
        System.out.println(remove_vowels("abcdef\nghijklmn"));
        System.out.println(remove_vowels("abcdef"));
        System.out.println(remove_vowels("aaaaa"));
        System.out.println(remove_vowels("aaBAA"));
        System.out.println(remove_vowels("zbcd"));
    }
}