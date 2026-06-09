package com.example;
public class HumanEval_56 {
    /**
     * brackets is a string of "<" and ">".
     * return true if every opening bracket has a corresponding closing bracket.
     * 
     * @param brackets the string to check
     * @return true if bracketing is correct, false otherwise
     */
    public static boolean correctBracketing(String brackets) {
        int cnt = 0;
        for (char x : brackets.toCharArray()) {
            if (x == '<') { cnt++; }
            if (x == '>') { cnt--; }
            if (cnt < 0) { return false; }
        }
        return cnt == 0;
    }
}