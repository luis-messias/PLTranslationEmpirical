import java.util.Scanner;

public class atcoder_AGC038_A {

    public static void solve(int H, int W, int A, int B) {
        // Initialize the answer grid. Since the Python code initializes with "0"s, we use a 2D array of Strings.
        String[][] answer = new String[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // Initialize based on the pattern derived from the Python code's initialization
                // The Python code initializes with "0"s implicitly by list comprehension, 
                // and then sets values based on the logic.
                // We will set the values based on the derived logic.
                
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

        // Print the result, concatenating elements of each row (mimicking ''.join(answer[i]))
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

        // Read H, W, A, B sequentially, mimicking the token reading from sys.stdin
        if (scanner.