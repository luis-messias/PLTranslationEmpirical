package com.example;
class Solution {
    public boolean correctBracketing(String brackets) {
        int cnt = 0;
        for (char x : brackets.toCharArray()) {
            if (x == '<') {
                cnt++;
            } else if (x == '>') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}