import java.util.Scanner;

public class atcoder_AGC038_A {

    public static void solve(int H, int W, int A, int B) {
        // Initialize the answer grid.
        String[][] answer = new String[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // Logic derived from Python:
                // If i < B:
                //   If j < A: answer[i][j] = "0"
                //   Else: answer[i][j] = "1"
                // Else (i >= B):
                //   If j < A: answer[i][j] = "1"
                //   Else: answer[i][j] = "0"
                
                if (i < B) {
                    if (j < A) {
                        answer[i][j] = "0";
                    } else {
                        answer[i][j] = "1";
                    }
                } else { // i >= B
                    if (j < A) {
                        answer[i][j] = "1";
                    } else {
                        answer[i][j] = "0";
                    }
                }
            }
        }

        // Print the result, concatenating elements of each row
        for (int i = 0; i < H; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < W; j++) {
                row.append(answer[i][j]);
            }
            System.out.println(row.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read H, W, A, B from standard input
        if (scanner.hasNextInt()) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            solve(H, W, A, B);
        }
        scanner.close();
    }
}
