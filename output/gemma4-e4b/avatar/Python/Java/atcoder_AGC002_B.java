import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC002_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // balls[i] stores [w, r] for ball i+1
        // Initialize all balls to [1, 0]
        int[][] balls = new int[N][2];
        for (int i = 0; i < N; i++) {
            balls[i][0] = 1; // w
            balls[i][1] = 0; // r
        }

        // Set balls[0] to [0, 1]
        balls[0][0] = 0;
        balls[0][1] = 1;

        // Process M pairs
        for (int k = 0; k < M; k++) {
            if (!scanner.hasNextInt()) {
                break;
            }
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Indices are 1-based in input, 0-based internally
            int x_idx = x - 1;
            int y_idx = y - 1;

            // Get current states
            int w_x = balls[x_idx][0];
            int r_x = balls[x_idx][1];
            int w_y = balls[y_idx][0];
            int r_y = balls[y_idx][1];

            // Update logic based on Python code
            if (w_x >= 1 && r_x >= 1) {
                // Case 1: w_x >= 1 and r_x >= 1
                balls[x_idx][0] -= 1;
                balls[y_idx][1] += 1;
            } else if (w_x == 0) {
                // Case 2: w_x == 0
                balls[x_idx][1] -= 1;
                balls[y_idx][1] += 1;
            } else {
                // Case 3: w_x < 0 (since w_x >= 0 is implied by initialization/updates)
                // This covers w_x = 0 and w_x < 0, but since we checked w_x == 0 already, 
                // this branch handles w_x < 0 (which shouldn't happen if logic is followed, 
                // but matches the Python structure: else block).
                balls[x_idx][0] -= 1;
                balls[y_idx][0] += 1;
            }
        }

        // Calculate the answer
        int ans = 0;
        for (int i = 0; i < N; i++) {
            // Check if balls[i][1] (r) is non-zero
            if (balls[i][1] != 0) {
                ans++;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}