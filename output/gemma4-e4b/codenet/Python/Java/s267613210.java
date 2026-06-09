import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s267613210 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read K and N (assuming they are on the first line)
        if (!scanner.hasNextLong()) return;
        long K = scanner.nextLong();
        int N = scanner.nextInt();

        // Read array A
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }

        // Calculate distances
        List<Long> dist = new ArrayList<>();

        // Adjacent distances: A[i+1] - A[i]
        for (int i = 0; i < N - 1; i++) {
            dist.add(A[i+1] - A[i]);
        }

        // Wrap-around distance: K + A[0] - A[N-1]
        if (N > 0) {
            dist.add(K + A[0] - A[N-1]);
        }

        // Find sum and max
        long sum = 0;
        long maxv = Long.MIN_VALUE;

        for (long d : dist) {
            sum += d;
            if (d > maxv) {
                maxv = d;
            }
        }

        // Print the result: sum - maxv
        System.out.println(sum - maxv);
        
        scanner.close();
    }
}