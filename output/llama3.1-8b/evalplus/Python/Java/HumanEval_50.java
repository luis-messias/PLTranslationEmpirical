package com.example;
public class HumanEval_50 {
    public static String encodeShift(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                int asciiOffset = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - asciiOffset + 5) % 26 + asciiOffset));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String decodeShift(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                int asciiOffset = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - asciiOffset - 5 + 26) % 26 + asciiOffset));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encodeShift("hello"));
        System.out.println(decodeShift(encodeShift("hello")));
    }
}