package com.example;
public class HumanEval_61 {

    public static boolean correctBracketing(String brackets) {

        int count = 0;

        for (char x : brackets.toCharArray()) {
            if (x == '(') count += 1;
            else if (x == ')') count -= 1;

            if (count < 0) return false;
        }

        return count == 0;

    }


    public static void main(String[] args) {

        System.out.println(correctBracketing("(")); // False

        System.out.println(correctBracketing("()")); // True

        System.out.println(correctBracketing("(()())")); // True

        System.out.println(correctBracketing(")(()")); // False

    }

}