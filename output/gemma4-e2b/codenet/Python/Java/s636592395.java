import java.util.Scanner;
import java.util.Arrays;

public class s636592395 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (first line)
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read the array A (second line)
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                A[i] = scanner.nextInt();
            }
        }

        // Sort A
        Arrays.sort(A);

        // Calculate ans = A[-1] - A[0]
        int ans = A[N - 1] - A[0];

        // Print ans
        System.out.println(ans);

        scanner.close();
    }
}