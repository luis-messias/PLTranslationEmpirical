import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class s546174362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // Read array A (using long to prevent overflow)
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        
        scanner.close();

        // Sort A initially
        Arrays.sort(A);

        // Simulation loop
        while (M > 0) {
            // 1. Process A[-1] (A[N-1])
            A[N - 1] /= 2;
            M--;
            
            // 2. Process elements A[i] starting