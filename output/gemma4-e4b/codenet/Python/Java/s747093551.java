import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class s747093551 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, M, X, Y
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        // Read list x (N elements)
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextInt();
        }

        // Read list y (M elements)
        int[] y = new int[M];
        for (int i = 0; i < M; i++) {
            y[i] = scanner.nextInt();
        }
        
        scanner.close();

        // Calculate max(max(x), X)
        // If N=0, max_x should be treated such that Math.max(max_x, X) is handled correctly.
        // Assuming N >= 1 based on typical problem constraints, but handling N=0 defensively.
        int max_x = N > 0 ? Arrays.stream(x).max().getAsInt() : Integer.MIN_VALUE;
        int leftSide = Math.max(max_x, X);

        // Calculate min(min(y), Y)
        int min_y = M > 0 ? Arrays.stream(y).min().getAsInt() : Integer.MAX_VALUE;
        int rightSide = Math.min(min_y, Y);

        // Check the condition: max(max(x), X) < min(min(y), Y)
        if (leftSide < rightSide) {
            System.out.println("No War");
        } else {
            System.out.println("War");
        }
    }
}