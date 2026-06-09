import java.util.Scanner;

public class s590045523 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Read L
        int[] L = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            L[i] = scanner.nextInt();
        }

        long ans = 0;

        // Iterate through all unique triplets (i, j, k) such that i < j < k
        // The loops correspond to the Python ranges:
        // i in range(N-2) => i up to N-3
        // j in range(i+1, N-1) => j up to N-2
        // k in range(j+1, N) => k up to N-1
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int a = L[i];
                    int b