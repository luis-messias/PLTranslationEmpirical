package com.example;
public class HumanEval_132 {
    public static boolean isNested(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ']') continue;
            int cnt = 0, maxNest = 0;
            for (int j = i; j < string.length(); j++) {
                if (string.charAt(j) == '[') {
                    cnt++;
                } else {
                    cnt--;
                }
                maxNest = Math.max(maxNest, cnt);
                if (cnt == 0) {
                    if (maxNest >= 2) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNested("[[]]")); // ➞ True
        System.out.println(isNested("][]]]]][[[[[[]")); // ➞ False
        System.out.println(isNested("[][]")); // ➞ False
        System.out.println(isNested("[]")); // ➞ False
        System.out.println(isNested("[[][]]")); // ➞ True
        System.out.println(isNested("[[]][[")); // ➞ True
    }
}