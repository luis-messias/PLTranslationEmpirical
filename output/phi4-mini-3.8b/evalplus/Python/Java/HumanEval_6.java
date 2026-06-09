package com.example;
import java.util.ArrayList;

import java.util.List;


public class HumanEval_6 {

    public static List<Integer> parseNestedParens(String parenString) {

        return splitAndCountDepth(parenString);

    }


    private static List<Integer> splitAndCountDepth(String input) {

        String[] groups = input.split(" ");

        int maxDepth;

        for (int i = 0; i < groups.length; i++) {

            if (!groups[i].isEmpty()) {

                char ch = ' ';
                int cnt = 0;
                while ((ch = groups[i].charAt(cnt)) != '\n') {
                    if (ch == '(') cnt++;
                    else if (ch == ')') cnt--;

                    maxDepth = Math.max(maxDepth, cnt);

                }

            } else {

                continue;

            }

        }


        List<Integer> depths = new ArrayList<>();

        for (int i = 0; i < groups.length; i++) {

            int depth = countMaxDepth(groups[i]);

            if (!groups[i].isEmpty()) {
                depths.add(depth);

            }
        }

        return depths;


    }


    private static int countMaxDepth(String group) {

        char ch;

        int cnt, maxCnt = 0;
        for (int i = 0; i < group.length(); ++i) {

            if ((ch = group.charAt(i)) == '(')

                cnt++;

            else if ((ch = group.charAt(i)) == ')')

                cnt--;

            maxCnt = Math.max(maxCnt, cnt);

        }

        return maxCnt;

    }


}