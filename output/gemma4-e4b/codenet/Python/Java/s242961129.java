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
        long[] A = new long[