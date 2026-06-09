package com.example;
public class HumanEval_140 {

    public static String fixSpaces(String text) {
        // Replace all spaces with underscores first.
        for (int i = 0; i < Math.min(text.length(), 2); i++) { 
            text = text.replace(" ", "_");
        }

        int count = 1;
        char[] chars = new Character[text.length()];

        System.arraycopy(text.toCharArray(), 0, chars, 0, text.length());

        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == ' ') {
                ++count; 
            } else { 
                while(count > 2 && (char) ('0' + count - 3) != '-') { // Check previous characters
                    text = String.valueOf(text.substring(0, i-count+1)) + "-" + text.substring(i);
                    --count;
                }
                if(chars[i] == ' ') {
                    ++count; 
                } else { 
                    count=1;
                }
            }

        while(count > 2) { // Handle trailing spaces
            text = String.valueOf(text.substring(0, chars.length-count+1)) + "-" + text.substring(chars.length);
            --count;
        }

        return text.replace(" ", "_");
    }

    public static void main(String[] args) {
        System.out.println(fixSpaces("Example")); // Example_
        System.out.println(fixSpaces("Example 1")); // Example_1
        System.out.println(fixSpaces(" Example 2")); // _Example_2
        System.out.println(fixSpaces(" Example   3")); // _Example-3
    }
}
