import java.util.Scanner;
import java.util.Arrays;

public class codeforces_612_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                a[i] = scanner.nextInt();
            } else {
                // Handle case where input might be incomplete
                return;
            }
        }

        // Initialize b
        int[] b = new int[n];
        // b = [0] * n is implicitly handled by array initialization in Java

        // Populate b
        for (int i = 0; i < n; i++) {
            // Python: b[a[i] - 1] = i
            // a[i] is 1-indexed value, so we use a[i] - 1 as the index
            b[a[i] - 1] = i;
        }

        // Calculate res
        long res = 0; // Use long just in case the sum gets large, although int might suffice based on constraints
        for (int i = 1; i < n; i++) {
            // Python: res += abs(b[i] - b[i - 1])
            res += Math.abs(b[i] - b[i - 1]);
        }

        System.out.println(res);

        scanner.close();
    }
}