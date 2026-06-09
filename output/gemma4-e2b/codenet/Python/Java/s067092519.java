import java.util.Scanner;

public class s067092519 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Initialize m[10][3][10]
        int[][][] m = new int[10][3][10];

        // Read N lines of data
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                int b = scanner.nextInt();
                int f = scanner.nextInt();
                int r = scanner.nextInt();
                int v = scanner.nextInt();
                
                // Indices are 1-based in input, convert to 0-based
                m[b - 1][f - 1][r - 1] += v;
            }
        }

        // Printing part
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                StringBuilder lineBuilder