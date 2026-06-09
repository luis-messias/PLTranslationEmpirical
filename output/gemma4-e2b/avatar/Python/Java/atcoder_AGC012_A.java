import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC012_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read array A
        // Since readInts in Python reads the rest of the line, we read the next line for A
        // Assuming A is on the next line based on typical competitive programming input style
        // If the input format is strictly line by line:
        
        // Read the line containing A
        if (!scanner.hasNextLine()) return;
        String lineA = scanner.nextLine();
        String[] parts = lineA.trim().split("\\s+");
        
        // Handle potential empty input or parsing issues if necessary, but assuming valid input structure
        if (parts.length == 0) return;
        
        int[] A = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            A[i] = Integer.parseInt(parts[i]);
        }

        // Sort A
        Arrays.sort(A);

        long ans = 0;
        int L = A.length;

        // Python loop: for i in range(len(A) - 2, len(A) - 2 * n - 1, -2):
        // This selects n elements starting from index L - 2, stepping by -2.
        
        int startIndex = L - 2;
        
        for (int k = 0; k < n; k++) {
            int i = startIndex - 2 * k;
            // Ensure index is valid, although the Python range definition implies it will be valid
            if (i >= 0) {
                ans += A[i];
            }
        }

        System.out.println(ans);
        
        scanner.close();
    }
}