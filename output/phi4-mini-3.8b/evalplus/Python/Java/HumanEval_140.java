package com.example;
public class HumanEval_140 {

    public static String fixSpaces(String text) {
        // Replace all spaces with underscores first.
        String ans = text;
        for (int i = 0; i < Math.min(ans.length(), 2); i++) { 
            ans = ans.replace(" ", "_");
        }

        // Now replace consecutive spaces greater than two
        int count = 1;
        char[] chars = ans.toCharArray();
        
        for(int i=1;i<chars.length;++i) {
            if(chars[i] == ' ') {
                ++count; 
            } else { 
                while(count > 2 && (char) ('0' + count - 3) != '-') { // Check previous characters
                    ans = String.valueOf(ans.substring(0, i-count+1)) + "-" + ans.substring(i);
                    --count;
                }
                if(chars[i] == ' ') {
                    ++count; 
                } else { 
                    count=1;
                }
            }

        while(count > 2) { // Handle trailing spaces
            ans = String.valueOf(ans.substring(0, chars.length-count+1)) + "-" + ans.substring(chars.length);
            --count;
        }

        return ans.replace(" ", "_");
    }

    public static void main(String[] args) {
        System.out.println(fixSpaces("Example")); // Example_
        System.out.println(fixSpaces("Example 1")); // Example_1
        System.out.println(fixSpaces(" Example 2")); // _Example_2
        System.out.println(fixSpaces(" Example   3")); // _Example-3
    }
}