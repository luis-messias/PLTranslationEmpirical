import java.util.*;
import java.io.*;

public class s846046431 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // Read A
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) break;
            A.add(scanner.nextInt());
        }
        
        scanner.close();

        // Sort A in descending order
        A.sort(Collections.reverseOrder());

        // Calculate S (Sum of A)
        long S = 0;
        for (int a : A) {
            S += a;
        }

        boolean possible = true;
        
        // Iterate through the first M elements
        for (int i = 0; i < M; i++) {
            int a_val = A.get(i);
            
            // Check the condition: a/S - 1/(4*M) < 0
            // Use double for accurate floating-point arithmetic
            double term1 = (double)a_val / S;
            double term2 = 1.0 / (4.0 * M);
            
            if (term1 - term2 < 0) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}