package com.example;
public class HumanEval_44 {

    public static String changeBase(int x, int base) {

        if (x == 0) return "0";

        StringBuilder ret = new StringBuilder();

        while (x != 0) {

            ret.append((char)(x % base + '0'));

            x /= base;

        }

        // Reverse the string since we appended in reverse order

        for(int i=ret.length()-1; i>=0 ;i--) {

            char temp = ret.charAt(i);

            ret.setCharAt(i, ret.charAt(ret.length() - 1 - i));

            ret.setCharAt(ret.length() - 1 - i, temp);

        }

        return ret.toString();

    }


    public static void main(String[] args) {

        System.out.println(changeBase(8, 3)); // prints '22'

        System.out.println(changeBase(8, 2)); // prints '1000'

        System.out.println(changeBase(7, 2)); // prints '111'

    }

}