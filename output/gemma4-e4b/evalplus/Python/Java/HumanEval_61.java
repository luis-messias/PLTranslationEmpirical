package com.example;
class Solution {
    /**
     * brackets is a string of "(" and ")".
     * return True if every opening bracket has a corresponding closing bracket.
     *
     * @param brackets The string of brackets.
     * @return True if the brackets are correctly balanced, False otherwise.
     */
    public boolean correctBracketing(String brackets) {
        int cnt = 0;
        for (char x : brackets.toCharArray()) {
            if (x == '(') {
                cnt++;
            } else if (x == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}