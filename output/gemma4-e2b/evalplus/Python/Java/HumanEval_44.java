package com.example;
public class HumanEval_44 {
    public static String changeBase(int x, int base) {
        if (x == 0) {
            return "0";
        }

        StringBuilder ret = new StringBuilder();
        
        // Since the problem implies base numbers are less than 10, 
        // the digits will be 0-9.
        while (x != 0) {
            int remainder = x % base;
            ret.insert(0, remainder);
            x = x / base;
        }
        return ret.toString();
    }
}