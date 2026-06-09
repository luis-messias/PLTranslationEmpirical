package com.example;
import java.util.*;

public class HumanEval_136 {
    public static Pair largestSmallestIntegers(List<Integer> lst) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for (Integer num : lst) {
            if (num < 0) {
                neg.add(num);
            } else if (num > 0) {
                pos.add(num);
            }
        }

        Integer maxNeg = Collections.max(neg);
        Integer minPos = Collections.min(pos);

        return new Pair(maxNeg, minPos == null ? null : minPos);
    }

    public static void main(String[] args) {
        List<Integer> lst1 = Arrays.asList(2, 4, 1, 3, 5, 7);
        System.out.println(largestSmallestIntegers(lst1));

        List<Integer> lst2 = new ArrayList<>();
        System.out.println(largestSmallestIntegers(lst2));

        List<Integer> lst3 = Collections.singletonList(0);
        System.out.println(largestSmallestIntegers(lst3));
    }
}

class Pair {
    public Integer maxNeg;
    public Integer minPos;

    public Pair(Integer maxNeg, Integer minPos) {
        this.maxNeg = maxNeg;
        this.minPos = minPos;
    }

    @Override
    public String toString() {
        return "(" + maxNeg + ", " + (minPos == null ? "null" : minPos) + ")";
    }
}