import java.util.Arrays;
import java.util.Scanner;

public class s934308496 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and X (assuming they are on the same line)
        // We use int for N and X as they are typically counts/parameters.
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        // Read M elements. Use long to prevent potential overflow when summing.
        long[] m = new long[n];
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextLong();
        }

        // Sort M
        Arrays.sort(m);

        // Calculate sum(m)
        long sumM = 0;
        for (long val : m) {
            sumM += val;
        }

        // Calculate the result: n + (x - sum(m)) // m[0]
        // We cast x to long for the calculation to maintain precision.
        long numerator = (long) x - sumM;
        long denominator = m[0];

        // Java's / operator performs integer division (truncation towards zero).
        // This matches Python's // behavior for non-negative results, 
        // and is the standard translation unless floor division for negative numbers is strictly required.
        long result = n + (numerator / denominator);

        System.out.println(result);
        
        scanner.close();
    }
}