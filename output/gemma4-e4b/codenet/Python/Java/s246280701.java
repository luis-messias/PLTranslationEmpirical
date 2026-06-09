import java.util.Scanner;
import java.lang.Math;

public class s246280701 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read array x
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input ends prematurely
                return;
            }
            x[i] = scanner.nextInt();
        }
        
        scanner.close();

        // Initialize ans to 10^10 (using long to prevent overflow)
        long ans = 10000000000L;

        // Iterate i from 0 to 100
        for (int i = 0; i <= 100; i++) {
            long currentSum = 0;
            
            // Calculate the sum of squared differences
            for (int j = 0; j < n; j++) {
                // Calculate |i - x[j]|
                // Use long for difference calculation to ensure safety before squaring
                long diff = (long)i - x[j];
                
                // Calculate (i - x[j])^2
                long sqDiff = diff * diff;
                
                currentSum += sqDiff;
            }

            // Update minimum answer
            if (currentSum < ans) {
                ans = currentSum;
            }
        }

        System.out.println(ans);
    }
}