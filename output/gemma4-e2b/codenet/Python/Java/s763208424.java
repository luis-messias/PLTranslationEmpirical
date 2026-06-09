import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Math;

public class s763208424 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Initialize min-heap (to store negatives, simulating max-heap)
        PriorityQueue<Long> a = new PriorityQueue<>();

        // Read the initial numbers and push their negatives
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLong()) {
                long val = scanner.nextLong();
                a.add(-val);
            }
        }

        // The Python code defines dis(x, y) = x // 2**y
        // We need to implement this logic inside the loop.

        for (int k = 0; k < m; k++) {
            // heappop(a) gets the smallest element (most negative)
            long x = a.poll();
            
            // Calculate dis(x, 1) = x // 2^1 = x / 2 (integer division)
            // Since x is negative, Java's / operator performs truncation towards zero.
            // We need floor division (x // 2).
            long result = x / 2; 
            
            // heappush(a, -dis(x, 1))
            // Push -(x // 2)
            a.add(-(result));
        }

        // Print -sum(a)
        long sum = 0;
        for (long val : a) {
            sum += val;
        }
        
        System.out.println(-sum);
        
        scanner.close();
    }
}