import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s103029464 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Read A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            A[i] = scanner.nextInt();
        }

        // B initialization
        int[] B = new int[N];

        // Main loop: i from N-1 down to 0
        for (int i = N - 1; i >= 0; i--) {
            int tmp_sum = 0;
            
            // Inner loop: j from (i + 1) * 2 - 1 up to N-1, step i + 1
            int start_j = (i + 1) * 2 - 1;
            int step = i + 1;
            
            for (int j = start_j; j < N; j += step) {
                // tmp_sum += B[j] % 2
                tmp_sum = (tmp_sum + B[j]) % 2;
            }
            
            // B[i] =
