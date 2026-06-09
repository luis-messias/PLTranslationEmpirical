package com.example;
public class HumanEval_27 {
    
    public static void main(String[] args) {
        System.out.println(flipCase("Hello")); // Example usage, should print "hELLO"
    }

    public static String flipCase(String str) {
        char[] chars = new Character[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            if(Character.isLowerCase(str.charAt(i))) {
                chars[i] = Character.toUpperCase(str.charAt(i));
            } else if(Character.isUpperCase(str.charAt(i))){
                chars[i] = Character.toLowerCase(str.charAt(i));
            }
        }

        return new String(chars);
    }
}