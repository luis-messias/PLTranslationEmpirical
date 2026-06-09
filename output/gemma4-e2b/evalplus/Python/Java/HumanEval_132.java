package com.example;
public class HumanEval_132 {
    public static boolean isNested(String string) {
        int n = string.length();

        for (int i = 0; i < n; i++) {
            if (string.charAt(i) == ']') {
                continue;
            }

            int cnt = 0;
            int max_nest = 0;

            for (int j = i; j < n; j++) {
                char current = string.charAt(j);

                if (current == '[') {
                    cnt += 1;
                } else { // current == ']'
                    cnt -= 1;
                }

                max_nest = Math.max(max_nest, cnt);

                if (cnt == 0) {
                    if (max_nest >= 2) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
}