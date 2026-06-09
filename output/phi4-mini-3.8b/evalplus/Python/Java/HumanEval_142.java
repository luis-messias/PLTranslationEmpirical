package com.example;
public class HumanEval_142 {

    public static int sumSqrts(List<Integer> lst) {

        int ans = 0;

        for (int i = 0; i < lst.size(); i++) {

            Integer num = lst.get(i);

            if ((i % 3 == 0)) {
                ans += Math.pow(num, 2);
            } else if ((i % 4 == 0) && (i % 3 != 0)) {
                ans += Math.pow(num, 3);
            } else {

                int value = num;

                // Handle null values in the list

                if (value == null) { 

                    continue; 
                }

                ans += value;
            }
        }

        return ans;

    }


}