import java.util.Scanner;

public class s906994739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read F (n x 10)
        int[][] F = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                F[i][j] = scanner.nextInt();
            }
        }

        // Read P (n x 10)
        int[][] P = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                P[i][j] = scanner.nextInt();
            }
        }

        // Initialize ans to -10^18 (using long)
        long ans = -1000000000000000000L;

        // Iterate i from 1 to 2^10