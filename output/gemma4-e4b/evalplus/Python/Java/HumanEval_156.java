package com.example;
class Solution {
    public static String intToMiniRoman(int number) {
        // m: Thousands (0 to 1)
        String[] m = {"", "m"};
        
        // c: Hundreds (0 to 9)
        String[] c = {"", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"};
        
        // x: Tens (0 to 9)
        String[] x = {"", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc"};
        
        // i: Ones (0 to 9)
        String[] i = {"", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"};
        
        // Calculate thousands component
        String thousands = m[number / 1000];
        
        // Calculate hundreds component
        int hundredsIndex = (number % 1000) / 100;
        String hundreds = c[hundredsIndex];
        
        // Calculate tens component
        int tensIndex = (number % 100) / 10;
        String tens = x[tensIndex];
        
        // Calculate ones component
        int onesIndex = number % 10;
        String ones = i[onesIndex];
        
        // Concatenate and return
        return thousands + hundreds + tens + ones