import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class codeforces_272_B {

    // Equivalent to Python function f(n)
    public static int f(int n) {
        int y = 1;
        while (n != 1) {
            if (n % 2 != 0) {
                y += 1;
            }
            n /= 2; // Integer division in Java handles floor division for positive integers
        }
        return y;
    }

    // Equivalent to Python function nPairsWithCommonFX(sequence)
    public static long nPairsWithCommonFX(List<Integer> sequence) {
        Map<Integer, List<Integer>> storage = new HashMap<>();
        List<Integer> FXs = new ArrayList<>();

        for (int value : sequence) {
            int y = f(value);
            
            storage.putIfAbsent(y, new ArrayList<>());
            storage.get(y).add(value);
            
            if (!FXs.contains(y)) {
                FXs.add(y);
            }
        }

        long totalSum = 0;
        for (int y : FXs) {
            int count = storage.get(y).size();
            // Calculation: sum(len(storage[y]) * len(storage[y])) - sum(len