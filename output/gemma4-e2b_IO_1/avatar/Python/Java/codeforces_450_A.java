import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_450_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Read the list l from the second line
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                l.add(scanner.nextInt());
            } else {
                // Handle case where input might end prematurely
                break;
            }
        }

        // Calculate l2
        List<Integer> l2 = new ArrayList<>();
        for (int i : l) {
            if (i % m == 0) {
                l2.add(i / m);
            } else {
                l2.add(i / m + 1);
            }
        }

        // Find mx
        int mx = Integer.MIN_VALUE;
        if (!l2.isEmpty()) {
            mx = l2.get(0);
            for (int val : l2) {
                if (val > mx) {
                    mx = val;
                }
            }
        }
        
        // Note: The Python code uses max(l2), which implies l2 is not empty.
        // If l2 is guaranteed non-empty (which it is if l is non-empty), we can simplify finding max.
        // Let's use Java's built-in max for simplicity if possible, or stick to manual iteration.
        
        if (!l2.isEmpty()) {
            mx = l2.get(0);
            for (int i = 1; i < l2.size(); i++) {
                if (l2.get(i) > mx) {
                    mx = l2.get(i);
                }
            }
        }


        // Find ind (index of the last occurrence where l2[i] == mx)
        int ind = -1; // Initialize ind to an invalid value
        for (int i = 0; i < l2.size(); i++) {
            if (l2.get(i) == mx) {
                ind = i;
            }
        }

        // Print ind + 1
        if (ind != -1) {
            System.out.println(ind + 1);
        }
    }
}
