import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC004_B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and X
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        // Read array A
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        scanner.close();

        // Initialize matrix B (N x N)
        // We use long for the matrix elements just in case, although they store minimums of ints.
        // Since the calculation involves sums later, let's stick to int for B as it stores min(a[i], a[k]).
        int[][] b = new int[n][n];

        // Fill Matrix B
        for (int i = 0; i < n; i++) {
            // m