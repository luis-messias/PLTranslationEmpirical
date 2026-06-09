import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC155_D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        long N_long = scanner.nextLong();
        int N = (int) N_long;
        long K = scanner.nextLong();

        // Read array A
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        scanner.close();

        // Sort A
        Arrays.sort(A);

        // Initialize binary search bounds
        // Using -10^18 - 1 and 10^18 + 1 for safety, ensuring they are long
        long ll = -1000000000000000000L - 1;
        long rr = 1000000000000000000L + 1
