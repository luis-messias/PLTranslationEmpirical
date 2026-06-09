import java.util.Scanner;
import java.util.Arrays;

public class codeforces_354_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n, L, R, QL, QR (First line)
        long n = scanner.nextLong();
        long L = scanner.nextLong();
        long R = scanner.nextLong();
        long QL = scanner.nextLong();
        long QR = scanner.nextLong();

        // Read W array (Second line)
        long[] W = new long[(int) n];
        for (int i = 0; i < n; i++) {
            W[i] = scanner.nextLong();
        }

        // sum_el[i] stores the sum of the first i elements of W
        // Size n+1
        long[] sumEl = new long[(int) n + 1];
        sumEl[0] = 0;
        for (int i = 1; i <= n; i++) {
            sumEl[i] = W[i - 1] + sumEl[i - 1];
        }

        // Initialize answer
        // answer = QR * (n - 1) + sum_el[n] * R
        long answer = QR * (n - 1) + sumEl[(int) n] * R;

        // Loop to find minimum energy
        for (int i = 1; i <= n; i++) {
            // i is the size of the left group
            // n - i is the size of the right group
            
            // energy = L * sum_el[i] + R * (sum_el[n] - sum_el[i])
            long energy = L * sumEl[i] + R * (sumEl[(int) n] - sumEl[i]);
            
            // Penalty/Bonus calculation
            if (i > (n - i)) {
                // Left group is larger
                // energy += (i - (n - i) - 1) * QL
                energy += (i - (n - i) - 1) * QL;
            } else if ((n - i) > i) {
                // Right group is larger
                // energy += ((n - i) - i - 1) * QR
                energy += ((n - i) - i - 1) * QR;
            }
            
            if (energy < answer) {
                answer = energy;
            }
        }

        System.out.println(answer);
        scanner.close();
    }
}