package com.example;

import java.util.ArrayList;
import java.util.List;

public class HumanEval_125 {

    public static void main(String[] args) {
        System.out.println(splitWords("Hello world!")); // ["Hello", "world!"]

        String result = splitWords("Hello,world!");

        if (result instanceof List<?>) { 

            for (String word : ((List<String>) result)) { 

                System.out.print(word + " "); 

            }

        } else {

            int count = Integer.parseInt(result);

            System.out.println(count); // 3

        }
    }


    public static String splitWords(String txt) throws Exception {
        
        if (txt.contains(" ") || txt.contains("\n") || txt.contains("\r") || txt.contains("\t")) { 

            return textToStringArray(txt.split("\\s+")); 

        } else if (txt.contains(",")) { 

            return textToStringArray(txt.split(","));

        } else {

            int cnt = 0;

            for (char ch : txt.toCharArray()) {
                
                char lowerCh;
                boolean isLowerCaseLetter = Character.isAlphabetic(ch) && !Character.isDigit(ch);

                if (!isLowerCaseLetter) continue; // Skip non-lowercase letters

                lowerCh = Character.toLowerCase(ch);
                int ordValue = lowerCh - ('a');

                if (ordValue % 2 == 1) cnt++;

            }

            return Integer.toString(cnt); 

        } 
    }


    private static String[] textToStringArray(String str) {
        
        List<String> list = new ArrayList<>();

        for (String s : split(str, " ")) {  

            if (!s.isEmpty()) {

                list.add(s);

            }

        }
        
        return list.toArray(new String[0]);

    }


    private static String[] split(String str, String delimiter) {
        
        List<String> parts = new ArrayList<>();

        int start = 0;

        while ((start = str.indexOf(delimiter, start)) != -1) {

            if (start > 0) {  

                parts.add(str.substring(start + delimiter.length(), start));

            }

            start += delimiter.length();

        }
        
        String lastPart = str.substring(start);

        if (!lastPart.isEmpty()) {
            
            parts.add(lastPart);
        }

        return parts.toArray(new String[parts.size()]);

    }
}
