package com.example;

public class HumanEval_156 {
    public static String intToMiniRoman(int number) {
        // m = ["", "m"]
        String[] m = {"", "m"};
        
        // c = ["", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"]
        String[] c = {"", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"};
        
        // x = ["", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc"]
        String[] x = {"", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc"};
        
        // i = ["", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"]
        String[] i = {"", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"};

        // thousands = m[number // 1000]
        String thousands = m[number / 1000];
        
        // hundreds = c[(number % 1000) // 100]
        int remainder1000 = number % 1000;
        int hundredsIndex = remainder1000 / 100;
        String hundreds = c[hundredsIndex];
        
        // tens = x[(number % 100) // 10]
        int remainder100 = number % 100;
        int tensIndex = remainder100 / 10;
        String tens = x[tensIndex];
        
        // ones = i[number % 10]
        String ones = i[number % 10];
        
        return thousands + hundreds + tens + ones;
    }
}
