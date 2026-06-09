package com.example;
public class HumanEval_119 {

    public static String matchParens(String[] strs) {

        boolean isValid = (validParens(strs[0].concat(strs[1]))) || 

                           (validParens(strs[1].concat(strs[0])));

        return isValid ? "Yes" : "No";

    }

    private static boolean validParens(String s) {

        int balance = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '(')
                ++balance;
            else
                --balance;

            if(balance < 0)

                return false; // Unbalanced parentheses

        }
        
        return balance == 0; // Check final balance is zero
        
    }

}