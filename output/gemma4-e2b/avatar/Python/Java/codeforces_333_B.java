import java.util.Scanner;

public class codeforces_333_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Initialize array b of size 2*n with all ones
        int size = 2 * n;
        int[] b = new int[size];
        for (int i = 0; i < size; i++) {
            b[i] = 1;
        }

        // Set initial elements to 0
        if (n > 0) {
            b[0] = 0;
            if (n - 1 >= 0) b[n - 1] = 0;
            if (n >= 0) b[n] = 0;
            if (2 * n - 1 < size) b[2 * n - 1] = 0;
        }

        // Process m updates
        for (int i = 0; i < m; i++) {
            if (!scanner.hasNextInt()) break;
            int r = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int c = scanner.nextInt();

            // Set elements to 0
            if (r - 1 >= 0 && r - 1 < size) {
                b[r - 1] = 0;
            }
            if (n + c - 1 >= 0 && n + c - 1 < size) {
                b[n + c - 1] = 0;
            }
        }

        // Conditional check and assignment
        if (n % 2 != 0) {
            int mid1 = n / 2;
            int mid2 = n + n / 2;

            // Check bounds before accessing
            if (mid1 >= 0 && mid1 < size && mid2 >= 0 && mid2 < size) {
                if (b[mid1] == 1 && b[mid2] == 1) {
                    b[mid1] = 0;
                }
            }
        }

        // Calculate and print the sum
        long sum = 0;
        for (int val : b) {
            sum += val;
        }
        System.out.println(sum);

        scanner.close();
    }
}