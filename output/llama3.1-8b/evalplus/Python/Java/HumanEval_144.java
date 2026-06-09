package com.example;
public class HumanEval_144 {
    public static boolean simplify(String x, String n) {
        int x1 = Integer.parseInt(x.split("/")[0]);
        int x2 = Integer.parseInt(x.split("/")[1]);
        int n1 = Integer.parseInt(n.split("/")[0]);
        int n2 = Integer.parseInt(n.split("/")[1]);
        return (x1 * n1) % (x2 * n2) == 0;
    }
}