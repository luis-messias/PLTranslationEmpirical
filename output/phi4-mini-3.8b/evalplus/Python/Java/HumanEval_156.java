package com.example;
public class HumanEval_156 {

    public static String intToMiniRoman(int number) {
        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }

        String[] thousands = {"", "m"};
        String[] hundreds = {"", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"};
        String[] tens = {"", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc"};
        String[] ones = {"", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"};

        int thousandsIndex = number / 1000;
        int hundredsIndex = (number % 1000) / 100;
        int tensIndex = (number % 100) / 10;
        int onesIndex = number % 10;

        String thousandsPart = thousands[thousandsIndex];
        String hundredsPart = hundreds[hundredsIndex];
        String tensPart = tens[tensIndex];
        String onesPart = ones[onesIndex];

        return thousandsPart + hundredsPart + tensPart + onesPart;
    }

    public static void main(String[] args) {
        System.out.println(intToMiniRoman(19)); // Output: xix
        System.out.println(intToMiniRoman(152)); // Output: clii
        System.out.println(intToMiniRoman(426)); // Output: cdxxvi
    }
}