package com.example;
public class HumanEval_161 {
    
    public static void main(String[] args) {
        System.out.println(solve("1234")); // Output: 4321
        System.out.println(solve("ab"));   // Output: AB
        System.out.println(solve("#a@C")); // Output: #A@c
    }

    public static String solve(String s) {
        boolean hasLetter = false;
        char[] ansArray = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                hasLetter = true;
                ansArray[i] = Character.isLowerCase(s.charAt(i)) ? 
                              Character.toUpperCase(s.charAt(i)) : 
                              Character.toLowerCase(s.charAt(i));
            } else {
                ansArray[i] = s.charAt(i);
            }
        }

        String result = new String(ansArray);

        if (!hasLetter) {
            return new StringBuilder(result).reverse().toString();
        }

        return result;
    }
}