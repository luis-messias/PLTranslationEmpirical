package com.example;
import java.util.ArrayList;

public class HumanEval_125 {

    public static void main(String[] args) {
        System.out.println(splitWords("Hello world!")); // ["Hello", "world!"]

        String result = splitWords("Hello,world!");

        if (result instanceof ArrayList<?>) { 

            for (String word : ((ArrayList<String>) result)) { 

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

                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) continue; // Skip non-lowercase letters

                char lowerCh = Character.toLowerCase(ch);

                int ordValue = lowerCh - ('a');

                if (ordValue % 2 == 1) cnt++;

            }

            return Integer.toString(cnt); 

        } 
    }


    private static String[] textToStringArray(String[] strings) {

        ArrayList<String> list = new ArrayList<>();

        for (String str : strings) {  

            list.add(str);

        }

        return list.toArray(new String[0]);

    }
}