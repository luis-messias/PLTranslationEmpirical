package com.example;
import java.util.*;

public class HumanEval_87 {
    public static List<int[]> getRow(List<List<Integer>> lst, int x) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            List<Integer> l = lst.get(i);
            for (int j = l.size() - 1; j >= 0; j--) {
                if (l.get(j).equals(x)) res.add(new int[]{i, j});
            }
        }
        Collections.sort(res, Comparator.comparingInt(a -> a[0]));
        Collections.sort(res, (a, b) -> Integer.compare(b[1], a[1]));
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lst = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 1, 6),
                Arrays.asList(1, 2, 3, 4, 5, 1)
        );
        System.out.println(getRow(lst, 1));
    }
}
