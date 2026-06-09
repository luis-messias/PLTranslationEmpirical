import java.util.Scanner;

public class codeforces_203_B {
    public static void solve_case() {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Initialize the count matrix (N x N)
        int[][] count = new int[n][n];

        // The Python code initializes count[i] = [0]*n inside a loop over n.
        // This is equivalent to initializing the 2D array to zeros, which Java does by default.
        // for (int i = 0; i < n; i++) {
        //     count[i] = new int[n]; // This is redundant if initialized correctly, but let's stick to the logic flow.
        // }

        int ans = -1;

        // Loop M times for the M queries
        for (int k = 0; k < m; k++) {
            if (!scanner.hasNextInt()) break;
            int x = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int y = scanner.nextInt();

            // Adjust coordinates (0-based indexing)
            x -= 1;
            y -= 1;

            boolean found = false;

            // Iterate over the 3x3 window around (x, y)
            // i ranges from x-2 to x (inclusive)
            for (int i = x - 2; i <= x; i++) {
                // j ranges from y-2 to y (inclusive)
                for (int j = y - 2; j <= y; j++) {
                    // Check bounds
                    if (i >= 0 && i < n && j >= 0 && j < n) {
                        count[i][j]++;
                        if (count[i][j] == 9) {
                            found = true;
                        }
                    }
                }
            }

            if (found) {
                ans = k + 1;
                break;
            }
        }

        System.out.println(ans);
        scanner.close();
    }

    public static void main(String[] args) {
        solve_case();
    }
}