import java.util.Arrays;
import java.util.Scanner;

public class s636592395 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        int N = scanner.nextInt();

        // Read the array A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        scanner.close();

        // Sort A
        Arrays.sort(A);

        // Calculate ans = A[N-1] - A[0]
        // A[0] is the minimum, A[N-1] is the maximum.
        int ans = A[N - 1] - A[0];

        // Print ans
        System.out.println(ans);
    }
}