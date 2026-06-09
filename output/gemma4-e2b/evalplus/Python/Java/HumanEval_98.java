package com.example;
class Solution {
    public int countUpper(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i += 2) {
            char c = s.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                cnt++;
            }
        }
        return cnt;
    }
}