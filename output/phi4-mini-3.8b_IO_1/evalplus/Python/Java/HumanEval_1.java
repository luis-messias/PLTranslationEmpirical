package com.example;
import java.util.ArrayList;

import java.util.List;


public class HumanEval_1 {

    public static List<String> separateParenGroups(String parenString) {
        int cnt = 0; // Initialize counter variable here to avoid uninitialized error.
        StringBuilder group = new StringBuilder();
        List<String> results = new ArrayList<>();


        for (char ch : parenString.toCharArray()) {
            if ("(".equals(ch)) cnt += 1;

            if (")".equals(ch)) cnt -= 1;


            // Ignore spaces

            if (!Character.isWhitespace(ch)) {

                group.append(ch);

            }


            if (cnt == 0) {

                results.add(group.toString());

                resultSize++;

                group.setLength(0); // Clear the StringBuilder for next use


            }

        }



        return results;

    }


    public static void main(String[] args) {
        List<String> separatedGroups = separateParenGroups("( ) (( )) (( )( ))");

        System.out.println(separatedGroups);
    }
}
