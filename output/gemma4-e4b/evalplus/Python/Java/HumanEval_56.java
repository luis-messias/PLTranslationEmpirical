package com.example;
class Solution {
    public boolean correctBracketing(String brackets) {
        int cnt = 0;
        for (int i = 0; i < brackets.length(); i++) {
            char x = brackets.charAt(i);
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