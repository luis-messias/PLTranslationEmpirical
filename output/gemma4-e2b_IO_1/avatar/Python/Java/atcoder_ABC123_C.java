import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC123_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (can be large, up to 10^10)
        if (!scanner.hasNextLong()) {
            return;
        }
        long N = scanner.nextLong();

        // Read A (5 elements)
        int[] A = new int[5];
        for (int i = 0; i < 5; i++) {
            if (!scanner.hasNextInt()) {
                return;
            }
            A[i] = scanner.nextInt();
        }

        // Find min(A)
        int minA = A[0];
        for (int i = 1; i < 5; i++) {
            if (A[i] < minA) {
                minA = A[i];
            }
        }

        // Calculate math.ceil(N / min(A)) + 4
        // N is long, minA is int. Perform floating-point division.
        double division = (double) N / minA;
        long result = (long) Math.ceil(division) + 4;

        System.out.println(result);
        
        scanner.close();
    }
}
