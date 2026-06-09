package com.example;
public class HumanEval_69 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 1, 2, 2, 3, 1})); // Example usage
    }


    public static Integer search(int[] lst) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : lst) {

            if (!count.containsKey(num)) {
                count.put(num, 0);
            }

            count.put(num, count.get(num) + 1);

        }


        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {

            if (entry.getValue() >= entry.getKey()) {

                ans = Math.max(ans, entry.getKey());

            }

        }

        return ans;

    }

}