import java.util.Scanner;

public class codeforces_333_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Initialize array b of size 2*n with all 1s
        int[] b = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            b[i] = 1;
        }

        // Set initial zeros
        b[0] = 0;
        b[n - 1] = 0;
        b[n] = 0;
        b[2 * n - 1] = 0;

        // Process M pairs of coordinates
        for (int i = 0; i < m; i++) {
            if (!scanner.hasNextInt()) break;
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            // Set b[r-1] and b[n+c-1] to 0
            b[r - 1] = 0;
            b[n + c - 1] = 0;
        }

        // Final conditional modification
        // Python logic: if n % 2 and b[n // 2] and b[n + n // 2]: b[n // 2] = 0
        // Check if n is odd AND b[n/2] is non-zero AND b[n + n/2] is non-zero
        if ((n % 2 != 0) && (b[n / 2] != 0) && (b[n + n / 2] != 0)) {
            b[n / 2] = 0;
        }

        // Calculate and print the sum
        long sum = 0;
        for (int value : b) {
            sum += value;
        }
        System.out.println(sum);
        
        scanner.close();
    }
}