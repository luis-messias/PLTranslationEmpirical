package com.example;
import java.util.HashMap;
import java.util.Map;

public class HumanEval_69 {
    public static int search(int[] lst) {
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

    public static void main(String[] args) {
        // Test cases
        int[] lst1 = {4, 1, 2, 2, 3, 1};
        System.out.println(search(lst1)); // Output: 2

        int[] lst2 = {1, 2, 2, 3, 3, 3, 4, 4, 4};
        System.out.println(search(lst2)); // Output: 3

        int[] lst3 = {5, 5, 4, 4, 4};
        System.out.println(search(lst3)); // Output: -1
    }
}