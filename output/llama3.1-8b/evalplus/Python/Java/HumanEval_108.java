package com.example;
import java.util.*;

public class HumanEval_108 {
    public static int countNums(int[] arr) {
        return Arrays.stream(arr).map(x -> judge(x)).sum();
    }

    private static int judge(int x) {
        String s = Integer.toString(Math.abs(x));
        if (s.charAt(0) == '-') {
            char[] chars = s.toCharArray();
            chars[0] = '-';
            s = new String(chars);
        }
        return Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum() > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 11, -11};
        System.out.println(countNums(arr));
    }
}