import java.util.Scanner;
import java.lang.Math;

public class s724326345 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read A, B, C, X, Y
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        long X = scanner.nextLong();
        long Y = scanner.nextLong();
        
        scanner.close();

        // Initialize ans to a value larger than any possible total (10^10)
        long ans = 10000000000L;

        // Determine the upper bound for k
        long maxK = Math.max(X, Y);

        // Loop for k from 0 up to maxK
        for (long k = 0; k <= maxK; k++) {
            // Calculate max(0, X - k)
            long termX = Math.max(0, X - k);
            
            // Calculate max(0, Y - k)
            long termY = Math.max(0, Y - k);
            
            // total = 2 * C * k + A * max(0, X - k) + B * max(0, Y - k)
            long total = 2 * C * k + A * termX + B * termY;
            
            if (total < ans) {
                ans = total;
            }
        }

        System.out.println(ans);
    }
}