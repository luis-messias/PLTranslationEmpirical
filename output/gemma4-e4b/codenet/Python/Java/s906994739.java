import java.util.Scanner;
import java.util.Arrays;

public class s906994739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // F[k][j]: Value for location k at time slot j
        int[][] F = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                F[i][j] = scanner.nextInt();
            }
        }

        // P[k][L]: Profit for location k if total open time is L
        // We assume the maximum possible accumulated time L fits within array bounds.
        // Since the maximum sum is 10 * max(F[k][j]), and F[k][j] are read as int,
        // we must assume the sum fits within a reasonable index range (e.g., 1000 or more).
        // For safety, we size P based on the maximum possible sum of 10 * 10^9, which is too large.
        // Assuming the input values F[k][j] are small enough that their sum L fits within standard array indexing (e.g., L <= 1000).
        // If we assume the input values are small (e.g., <= 100), max L is 1000.
        // Let's use a safe upper bound for the sum, assuming the problem constraints keep it manageable.
        // If we assume the input values are small enough that the sum L <= 1000:
        final int MAX_TIME_SUM = 1001; 
        int[][] P = new int[n][MAX_TIME_SUM];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                P[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();

        // Initialize ans to a very small number (equivalent to -10^18)
        long ans = -1000000000000000000L;

        // Iterate through all subsets of time slots (i from 1 to 2^10 - 1)
        for (int i