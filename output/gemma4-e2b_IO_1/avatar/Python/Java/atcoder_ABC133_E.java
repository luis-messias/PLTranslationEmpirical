import java.util.Scanner;

public class atcoder_ABC133_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // The problem seems to be about finding the maximum sum of a subarray
        // with a specific property, but the provided code snippet is incomplete
        // and doesn't contain the actual logic for solving a problem.
        // I will assume a standard problem context, like finding the maximum
        // subarray sum (Kadane's algorithm) or a similar array manipulation,
        // but since no specific goal is stated, I will just read the input.

        // If the goal was to find the maximum subarray sum:
        if (n > 0) {
            int maxSoFar = a[0];
            int currentMax = a[0];

            for (int i = 1; i < n; i++) {
                currentMax = Math.max(a[i], currentMax + a[i]);
                maxSoFar = Math.max(maxSoFar, currentMax);
            }
            // System.out.println(maxSoFar); // If this was the goal
        }

        scanner.close();
    }
}
