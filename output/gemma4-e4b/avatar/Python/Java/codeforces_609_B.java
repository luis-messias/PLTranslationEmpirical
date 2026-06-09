import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeforces_609_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read lst (n elements)
        int[] lst = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                return;
            }
            lst[i] = scanner.nextInt();
        }

        // Frequency counting (l)
        Map<Integer, Integer> l = new HashMap<>();
        for (int x : lst) {
            l.put(x, l.getOrDefault(x, 0) + 1);
        }

        // Use a mutable copy of the frequency map for the calculation loop
        Map<Integer, Integer> currentCounts = new HashMap<>(l);

        long res = 0;

        // Calculation loop
        for (int i = 0; i < n; i++) {
            int element = lst[i];
            int count = currentCounts.get(element);

            if (count > 1) {
                // Case 1: Element appears more than once
                res += (long)n - i - count;
                // Decrement count in the mutable map
                currentCounts.put(element, count - 1);
            } else {
                // Case 2: Element appears exactly once
                res += (long)n - i - 1;
            }
        }

        System.out.println(res);
    }
}