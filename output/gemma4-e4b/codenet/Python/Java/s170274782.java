import java.util.Scanner;
import java.lang.Math;

public class s170274782 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        
        // Read A[0]
        int[] A0 = new int[N];
        for (int i = 0; i < N; i++) {
            A0[i] = scanner.nextInt();
        }
        
        // Read A[1]
        int[] A1 = new int[N];
        for (int i = 0; i < N; i++) {
            A1[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        // Initialize maxCount to the smallest possible long value
        long maxCount = Long.MIN_VALUE;
        
        // Loop i from 0 to N-1
        for (int i = 0; i < N; i++) {
            // Calculate sum1: A0[0] to A0[i] (Prefix sum)
            long sum1 = 0;
            for (int j = 0; j <= i; j++) {
                sum1 += A0[j];
            }
            
            // Calculate sum2: A1[i] to A1[N-1] (Suffix sum)
            long sum2 = 0;
            for (int j = i; j < N; j++) {
                sum2 += A1[j];
            }
            
            long currentCount = sum1 + sum2;
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }
        
        System.out.println(maxCount);
    }
}