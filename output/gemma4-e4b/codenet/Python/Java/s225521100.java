import java.util.Scanner;

public class s225521100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // Initialize array A of size N with 0s
        int[] A = new int[N];

        // Process K groups of indices
        for (int i = 0; i < K; i++) {
            // Read d
            if (!scanner.hasNextInt()) return;
            int d = scanner.nextInt();

            // Read d indices
            int[] AA = new int[d];
            for (int j = 0; j < d; j++) {
                if (!scanner.hasNextInt()) return;
                AA[j] = scanner.nextInt();
            }

            // Mark the corresponding positions in A as 1
            for (int j = 0; j < d; j++) {
                int index = AA[j];
                // Input indices are 1-based, array A is 0-based
                if (index >= 1 && index <= N) {
                    A[index - 1] = 1;
                }
            }
        }

        // Count the number of zeros
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                count++;
            }
        }

        // Print the result
        System.out.println(count);

        scanner.close();
    }
}