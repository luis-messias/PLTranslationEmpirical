import java.util.Scanner;
import java.util.Arrays;

public class s048491063 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, M, Q
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();

        // 1. Initialize train grid (N x N)
        int[][] train = new int[N][N];

        // 2. Process M updates
        for (int i = 0; i < M; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            // l and r are 1-indexed, convert to 0-indexed
            train[l - 1][r - 1]++;
        }

        // 3. Calculate accum array (