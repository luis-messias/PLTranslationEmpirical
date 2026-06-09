import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class codeforces_56_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read array A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                A[i] = scanner.nextInt();
            } else {
                // Handle case where input might be incomplete, though unlikely based on problem context
                return;
            }
        }

        // Initialize mn and mx
        int mn = N + 1;
        int mx = -1;

        // Find mn and mx
        for (int i = 0; i < N; i++) {
            // Check if A[i] != i + 1 (1-based index check)
            if (i + 1 != A[i]) {
                mn = Math.min(mn, i);
                mx = Math.max(mx, i);
            }
        }

        if (mx == -1) {
            System.out.println("0 0");
        } else {
            // Perform list manipulation (A = A[:mn] + A[mn:mx+1][::-1] + A[mx+1:])
            
            // Part 1: A[0] to A[mn-1]
            // Part 2: A[mn] to A[mx] reversed
            // Part 3: A[mx+1] to end
            
            // Java implementation using ArrayList for easier manipulation, or manual array construction.
            // Since the Python code uses list concatenation and slicing, we will reconstruct the array.
            
            // Part 1: A[0] to A[mn-1]
            int[] part1 = Arrays.copyOfRange(A, 0, mn);

            // Part 2: A[mn] to A[mx] reversed
            int[] middle = Arrays.copyOfRange(A, mn, mx + 1);
            
            // Reverse the middle part
            int[] reversedMiddle = new int[middle.length];
            for (int i = 0; i < middle.length; i++) {
                reversedMiddle[i] = middle[middle.length - 1 - i];
            }

            // Part 3: A[mx+1] to end
            int[] part3 = Arrays.copyOfRange(A, mx + 1, N);

            // Combine the parts
            int[] A_new = new int[N];
            
            // Copy Part 1
            System.arraycopy(part1, 0, A_new, 0, part1.length);
            
            // Copy Reversed Middle
            System.arraycopy(reversedMiddle, 0, A_new, part1.length, reversedMiddle.length);
            
            // Copy Part 3
            System.array