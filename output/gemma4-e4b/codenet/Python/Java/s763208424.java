import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class s763208424 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Initialize the min-heap (PriorityQueue)
        // We store negative values to simulate a max-heap based on original values.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Read N initial values and push their negatives
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) break;
            int val = scanner.nextInt();
            pq.offer(-val);
        }

        // Helper function equivalent: dis(x, y) = x // 2^y
        // Since y is always 1 in the loop, we calculate x / 2.
        // x here is the original value V = -P.
        
        for (int i = 0; i < m; i++) {
            // 1. Pop the smallest element (most negative, corresponding to max original value V)
            if (pq.isEmpty()) break;
            int poppedNegative = pq.poll();
            
            // Original value V = -poppedNegative
            long V = (long) -poppedNegative;
            
            // 2. Calculate D = V / 2 (integer division)
            long D = V / 2;
            
            // 3. Push -D back into the heap
            pq.offer((int) -D);
        }

        // Calculate the sum of all remaining elements in the heap
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        // The result is -sum
        System.out.println(-sum);
        
        scanner.close();
    }
}