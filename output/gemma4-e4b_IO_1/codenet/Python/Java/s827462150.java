import java.util.Scanner;
import java.util.Arrays;

public class s827462150 {

    // Helper function to calculate F(x, y, z) = x^2 + y^2 + z^2 + xy + yz + zx
    private static long calculateF(long x, long y, long z) {
        return x * x + y * y + z * z + x * y + y * z + z * x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n. Since n determines array size and loop bounds, we use int for it,
        // but calculations involving n must use long.
        int nInt = scanner.nextInt();
        long n = nInt;
        scanner.close();

        // A stores the counts. Since the count can potentially exceed Integer.MAX_VALUE, we use long.
        long[] A = new long[nInt];

        long x = 1;
        long y = 1;
        long z = 1;

        // Outer loop (x)
        while (calculateF(x, y, z) <= n) {
            // Middle loop (y)
            while (calculateF(x, y, z) <= n) {
                // Inner loop (z)
                while (calculateF(x, y, z) <= n) {
                    long i = calculateF(x, y, z);
                    // i is guaranteed to be <= n. Index is i - 1.
                    A[(int) (i - 1)] += 1;
                    z += 1;
                }
                // Reset z and increment y
                z = 1;
                y += 1;
            }
            // Reset y and z, and increment x
            y = 1;
            z = 1;
            x += 1;
        }

        // Print the results
        for (int i = 0; i < nInt; i++) {
            System.out.println(A[i]);
        }
    }
}
