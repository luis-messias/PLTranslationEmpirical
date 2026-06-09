import java.util.Arrays;
import java.util.Scanner;

public class atcoder_AGC003_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read N values and construct array A
        // A[i] = V_i * N + i
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextLong()) {
                return;
            }
            long V_i = scanner.nextLong();
            A[i] = V_i * N + i;
        }
        
        // Sort A
        Arrays.sort(A);

        int cnt = 0;
        
        // Iterate through the sorted array A
        for (int i = 0; i < N; i++) {
            // Calculate d = (A[i] % N) % 2
            // A[i] % N gives a long remainder. We take its parity.
            long remainder = A[i] % N;
            int d = (int) (remainder % 2);
            
            // Check if d % 2 != i % 2
            if (d != (i % 2)) {
                cnt++;
            }
        }
        
        // Print cnt // 2 (integer division)
        System.out.println(cnt / 2);
    }
}
