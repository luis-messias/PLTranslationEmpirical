import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class s242961129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read A (original array)
        long[] A_orig = new long[N];
        for (int i = 0; i < N; i++) {
            A_orig[i] = scanner.nextLong();
        }

        // Calculate initial ans based on the last element of the original A
        // Python: ans=abs(A[-1])
        long ans = Math.abs(A_orig[N - 1]);

        // Create padded array A (size N+2)
        long[] A = new long[N + 2];
        A[0] = 0;
        for (int i = 0; i < N; i++) {
            A[i + 1] = A_orig[i];
        }
        A[N + 1] = 0;

        // Initialize diff array
        long[] diff = new long[N];

        // First loop: i from 1 to N
        for (int i = 1; i <= N; i++) {
            // Calculate dif = abs(A[i]-A[i-1]) + abs(A[i]-A[i+1]) - abs(A[i-1]-A[i+1])
            long term1 = Math.abs(A[i] - A[i - 1]);
            long term2 = Math.abs(A[i] - A[i + 1]);
            long term3 = Math.abs(A[i - 1] - A[i + 1]);
            long dif = term1 + term2 - term3;

            // Update ans: ans += abs(A[i]-A[i-1])
            ans += term1;

            // Store diff[i-1] = dif
            diff[i - 1] = dif;
        }

        // Second loop: i from 0 to N-1
        for (int i = 0; i < N; i++) {
            System.out.println(ans - diff[i]);
        }
    }
}
