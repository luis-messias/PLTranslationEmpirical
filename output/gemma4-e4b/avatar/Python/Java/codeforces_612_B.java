import java.util.Scanner;
import java.lang.Math;

public class codeforces_612_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read array A
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input might end prematurely
                return;
            }
            a[i] = scanner.nextInt();
        }

        // Initialize array B
        int[] b = new int[n];

        // Populate B: b[a[i] - 1] = i
        for (int i = 0; i < n; i++) {
            // a[i] is 1-based value, a[i] - 1 is 0-based index
            b[a[i] - 1] = i;
        }

        // Calculate the sum of absolute differences
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += Math.abs(b[i] - b[i - 1]);
        }

        System.out.println(res);
        
        scanner.close();
    }
}