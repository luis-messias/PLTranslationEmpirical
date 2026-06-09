import java.util.Scanner;
import java.lang.Math;

public class s663509070 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and D
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        int D = scanner.nextInt();

        // Read the matrix
        int[][] mat = new int[N][D];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < D; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();

        int count = 0;

        // Iterate over all pairs of rows (i, j) where i < j
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                
                // Calculate the sum of squared differences (sum of squares)
                long sumSq = 0;
                for (int k = 0; k < D; k++) {
                    long diff = mat[i][k] - mat[j][k];
                    sumSq += diff * diff;
                }

                // Calculate the Euclidean distance
                double dist = Math.sqrt(sumSq);

                // Check if the distance is an integer
                // We check if the double value is equal to its floor value
                if (dist == Math.floor(dist)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}