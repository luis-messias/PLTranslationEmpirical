package com.example;
public class HumanEval_134 {
    public static boolean checkIfLastCharIsALetter(String txt) {
        if (txt.length() == 0) return false;
        if (txt.length() == 1) return Character.isLetter(txt.charAt(0));
        return Character.isLetter(txt.charAt(txt.length() - 1)) && txt.charAt(txt.length() - 2) == ' ';
    }

    public static void main(String[] args) {
        System.out.println(checkIfLastCharIsALetter("apple pie")); // False
        System.out.println(checkIfLastCharIsALetter("apple pi e")); // True
        System.out.println(checkIfLastCharIsALetter("apple pi e ")); // False
        System.out.println(checkIfLastCharIsALetter("")); // False
    }
}