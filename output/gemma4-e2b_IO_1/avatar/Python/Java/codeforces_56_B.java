import java.util.Scanner;
import java.util.Arrays;

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
                // Handle potential input error
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
            // Perform list manipulation: A = A[:mn] + A[mn:mx+1][::-1] + A[mx+1:]
            
            // Part 1: A[0] to A[mn-1]
            int[] part1 = Arrays.copyOfRange(A, 0, mn);

            // Part 2: A[mn] to A[mx] reversed
            int[] middle = Arrays.copyOfRange(A, mn, mx + 1);
            
            int len_middle = middle.length;
            int[] reversedMiddle = new int[len_middle];
            for (int i = 0; i < len_middle; i++) {
                reversedMiddle[i] = middle[len_middle - 1 - i];
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
            System.arraycopy(part3, 0, A_new, part1.length + reversedMiddle.length, part3.length);

            // Check if the resulting array is sorted
            boolean isSorted = true;
            for (int i = 0; i < N - 1; i++) {
                if (A_new[i] > A_new[i + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                // Output mn + 1 and mx + 1 (1-based indices)
                System.out.println(mn + 1 + " " + mx + 1);
            } else {
                System.out.println("0 0");
            }
        }
        scanner.close();
    }
}
