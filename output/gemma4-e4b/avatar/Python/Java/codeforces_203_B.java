import java.util.Scanner;

public class codeforces_203_B {

    public static void solveCase() {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Initialize count array
        int[][] count = new int[n][n];
        // Java initializes int arrays to 0 by default, so explicit initialization loop is not strictly necessary for count[i][j] = 0.

        int ans = -1;

        // Process M cases
        for (int k = 0; k < m; k++) {
            if (!scanner.hasNextInt()) {
                // Should not happen if M is correct, but good practice
                break;
            }
            
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Convert to 0-indexed
            x -= 1;
            y -= 1;

            boolean found = false;

            // Iterate over the specified neighborhood: i from x-2 to x, j from y-2 to y
            for (int i = x - 2; i <= x; i++) {
                for (int j = y - 2; j <= y; j++) {
                    // Boundary check
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
        solveCase();
    }
}