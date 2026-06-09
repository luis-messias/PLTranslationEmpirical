import java.util.Arrays;
import java.util.Scanner;

public class s546174362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // Read array A (using long to prevent overflow)
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        
        scanner.close();

        // Sort A initially
        Arrays.sort(A);

        // Simulation loop
        while (M > 0) {
            // 1. Process A[N-1] (the largest element)
            A[N - 1] /= 2;
            M--;
            
            // 2. Process elements A[i] starting from N-3 down to 0
            // Python index i=-2 corresponds to Java index N-3
            int i = N - 3; 
            
            while (M > 0 && i >= 0 && A[i] >= A[N - 1]) {
                A[i] /= 2;
                M--;
                i--;
            }
            
            // 3. Re-sort A
            Arrays.sort(A);
        }

        // Calculate and print the sum of A
        long sum = 0;
        for (long val : A) {
            sum += val;
        }
        System.out.println(sum);
    }
}
