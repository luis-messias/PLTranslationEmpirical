import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class codeforces_624_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read array A. Using Integer[] to allow Collections.reverseOrder() sorting.
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Sort A descendingly
        Arrays.sort(a, Collections.reverseOrder());

        long ans = 0;
        // Initialize pre to a very large number (equivalent to float('inf'))
        long pre = Long.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            long current_a = a[j];

            // Calculate contribution: max(0, min(pre - 1, a[j]))
            long contribution = Math.max(0, Math.min(pre - 1, current_a));
            ans += contribution;

            // Update pre: max(0, min(pre - 1, a[j]))
            pre = Math.max(0, Math.min(pre - 1, current_a));
        }

        System.out.println(ans);
        
        scanner.close();
    }
}