import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC123_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read A (5 elements)
        int[] A = new int[5];
        for (int i = 0; i < 5; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where not enough inputs are provided
                return;
            }
            A[i] = scanner.nextInt();
        }
        
        scanner.close();

        // Find min(A)
        int minA = A[0];
        for (int i = 1; i < 5; i++) {
            if (A[i] < minA) {
                minA = A[i];
            }
        }

        // Calculate math.ceil(N / min(A)) + 4
        // Use double casting to ensure floating-point division
        double ratio = (double) N / minA;
        double ceiledResult = Math.ceil(ratio);
        
        // The final result is printed as an integer (long to be safe)
        long finalResult = (long) ceiledResult + 4;

        System.out.println(finalResult);
    }
}