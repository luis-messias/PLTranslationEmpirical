package com.example;
import java.util.List;
import java.util.ArrayList;

public class HumanEval_68 {

    public static List<Integer> pluck(List<Integer> nodes) {
        if (nodes.isEmpty()) {
            return new ArrayList<>();
        }

        int minEven = Integer.MAX_VALUE;
        for (int i : nodes) {
            if (i % 2 == 0 && i < minEven) {
                minEven = i;
            }
        }

        boolean foundMinEven = false;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            int nodeValue = nodes.get(i);
            if (nodeValue == minEven && !foundMinEven) {
                result.add(minEven);
                result.add(i + 1); // Adding index as per problem statement
                foundMinEven = true;
            }
        }

        return result.isEmpty() ? new ArrayList<>() : result;
    }

}