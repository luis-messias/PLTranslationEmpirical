import java.util.Scanner;
import java.util.Arrays;

public class codeforces_354_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n, L, R, QL, QR
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        int QL = scanner.nextInt();
        int QR = scanner.nextInt();

        // Read W
        int[] W = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            W[i] = scanner.nextInt();
        }

        // Calculate prefix sums (sum_el)
        // sum_el will have size n+1, initialized with 0 at index 0
        long[] sum_el = new long[n + 1];
        sum_el[0] = 0;
        for (int i = 1; i <= n; i++) {
            // W is 0-indexed, W[i-1] is the i-th element
            sum_el[i] = W[i - 1] + sum_el[i - 1];
        }

        // Calculate initial answer
        // answer = QR * (n - 1) + sum_el[n] * R
        long answer = (long) QR * (n - 1) + sum_el[n] * R;

        // Iterate to find the minimum energy
        for (int i = 1; i <= n; i++) {
            // energy = L * sum_el[i] + R * (sum_el[n] - sum_el[i])
            long energy = (long) L * sum_el[i] + (long) R * (sum_el[n] - sum_el[i]);

            // Conditional adjustments
            if (i > (n - i)) {
                // i > n - i  => 2i > n
                // energy = energy + ( i - ( n - i ) - 1 ) * QL
                energy = energy + (long) (i - (n - i) - 1) * QL;
            } else if ((n - i) > i) {
                // n - i > i => n > 2i
                // energy = energy + ( ( n - i ) - i - 1 ) * QR
                energy = energy + (long) ((n - i) - i - 1) * QR;
            }

            if (energy < answer) {
                answer = energy;
            }
        }

        System.out.println(answer);
        scanner.close();
    }
}