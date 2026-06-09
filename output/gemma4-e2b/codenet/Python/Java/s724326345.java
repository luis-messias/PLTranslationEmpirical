import java.util.Scanner;
import java.lang.Math;

public class s724326345 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read A, B, C, X, Y
        if (!scanner.hasNextLong()) return;
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        long X = scanner.nextLong();
        long Y = scanner.nextLong();
        
        // Initialize ans to 10^10
        long ans = 10000000000L;

        long maxXY = Math.max(X, Y);

        // Iterate k from 0 to max(X, Y)
        for (long k = 0; k <= maxXY; k++) {
            // Calculate max(0, X - k) and max(0, Y - k)
            long termX = Math.max(0, X - k);
            long termY = Math.max(0, Y - k);
            
            // Calculate total = 2 * C * k + A * max(0, X - k) + B * max(0, Y - k)
            long total = 2 * C * k + A * termX + B * termY;
            
            if (total < ans) {
                ans = total;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}