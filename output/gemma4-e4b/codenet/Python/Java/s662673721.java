import java.util.Scanner;
import java.lang.Math;

public class s662673721 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N as a long to handle values up to 10^18
        long n = scanner.nextLong();
        scanner.close();

        // Initialize ans to 10^18 (a sufficiently large number)
        long ans = 1000000000000000000L;

        // The loop iterates up to floor(sqrt(n))
        // We cast Math.sqrt(n) to long to get the integer floor.
        long limit = (long) Math.sqrt(n);

        for (long i = 1; i <= limit; i++) {
            if (n % i == 0) {
                long j = n / i;
                
                // Calculate i + j - 2
                long currentSum = i + j - 2;
                
                // Update minimum answer
                if (currentSum < ans) {
                    ans = currentSum;
                }
            }
        }

        System.out.println(ans);
    }
}