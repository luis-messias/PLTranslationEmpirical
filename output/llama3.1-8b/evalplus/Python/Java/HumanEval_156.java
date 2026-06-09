package com.example;
public class HumanEval_156 {
    public static String intToMiniRoman(int number) {
        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }

        String[] m = {"", "m"};
        String[] c = {"", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"};
        String[] x = {"", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc"};
        String[] i = {"", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"};

        int thousands = number / 1000;
        int hundreds = (number % 1000) / 100;
        int tens = (number % 100) / 10;
        int ones = number % 10;

        return m[thousands] + c[hundreds] + x[tens] + i[ones];
    }

    public static void main(String[] args) {
        System.out.println(intToMiniRoman(19).equals("xix"));
        System.out.println(intToMiniRoman(152).equals("clii"));
        System.out.println(intToMiniRoman(426).equals("cdxxvi"));
    }
}