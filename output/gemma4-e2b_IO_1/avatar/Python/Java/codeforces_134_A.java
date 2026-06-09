import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_134_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read W
        List<Integer> w = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                w.add(scanner.nextInt());
            }
        }

        // Calculate X (sum of w)
        long x = 0;
        for (int val : w) {
            x += val;
        }

        // Calculate d
        List<Integer> d = new ArrayList<>();
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                // Check if (x - w[i]) / (n - 1) == w[i]
                // To avoid floating point issues, we check: x - w[i] == w[i] * (n - 1)
                // Since the Python code uses division, we must handle integer division carefully.
                // In Java, we use long for intermediate calculations to prevent overflow, 
                // although the comparison itself involves division.
                
                // Python: (x - w[i]) / (n - 1) == w[i]
                // Java equivalent using integer arithmetic:
                // (x - w[i]) == w[i] * (n - 1)
