import java.util.Scanner;
import java.lang.Math;

public class s246280701 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read x
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            x[i] = scanner.nextInt();
        }

        // Initialize ans to a large value (10^10)
        long ans = 10000000000L; // 10^10

        // Iterate i from 0 to 100
        for (int i = 0; i <= 100; i++) {
            long currentSum = 0;
            // Calculate sum of squared differences: sum((i - x[j])^2)
            for (int j = 0; j < n; j++) {
                long diff = (long) i - x[j];
                currentSum += diff * diff;
            }

            // Update ans if current sum is smaller
            if (currentSum < ans) {
                ans = currentSum;
            }
        }

        System.out.println(ans);

        scanner.close();
    }
}