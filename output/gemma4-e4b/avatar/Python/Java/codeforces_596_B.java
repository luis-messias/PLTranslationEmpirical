import java.util.Scanner;
import java.lang.Math;

public class codeforces_596_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the array r
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input ends prematurely
                n = i;
                r = java.util.Arrays.copyOf(r, n);
                break;
            }
            r[i] = scanner.nextInt();
        }
        
        scanner.close();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Calculate ans = |r[0]|
        // Use long to prevent potential overflow during summation
        long ans = Math.abs(r[0]);

        // Loop and sum differences: ans += |r[i] - r[i-1]|
        for (int i = 1; i < n; i++) {
            // Calculate absolute difference. Casting to long before subtraction 
            // ensures the difference calculation itself doesn't overflow if r[i] and r[i-1] are large.
            long diff = Math.abs((long)r[i] - r[i - 1]);
            ans += diff;
        }

        System.out.println(ans);
    }
}