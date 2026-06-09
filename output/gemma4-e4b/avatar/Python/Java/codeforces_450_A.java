import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_450_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read list L
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                return;
            }
            l.add(scanner.nextInt());
        }

        // Process L to create L2
        List<Integer> l2 = new ArrayList<>();
        for (int i : l) {
            int val;
            if (i % m == 0) {
                val = i / m;
            } else {
                // Equivalent to Python's i // m + 1 for positive integers
                val = i / m + 1;
            }
            l2.add(val);
        }

        // Find max(l2)
        int mx = Integer.MIN_VALUE;
        for (int val : l2) {
            if (val > mx) {
                mx = val;
            }
        }

        // Find the index of the first occurrence of mx
        int index = -1;
        for (int i = 0; i < l2.size(); i++) {
            if (l2.get(i) == mx) {
                index = i;
                break; // Found the first occurrence
            }
        }

        // Print index + 1 (1-based indexing)
        System.out.println(index + 1);
        
        scanner.close();
    }
}