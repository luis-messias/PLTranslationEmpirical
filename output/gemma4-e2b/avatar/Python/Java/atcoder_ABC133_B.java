import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC133_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and d
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int d = scanner.nextInt();

        // Read points
        int[][] points = new int[n][d];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                if (!scanner.hasNextInt()) return;
                points[i][j] = scanner.nextInt();
            }
        }

        int count = 0;

        // Calculate distances and count integer ones
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double tmp = 0.0;
                // Calculate squared Euclidean distance
                for (int k = 0; k < d; k++) {
                    long diff = (long)points[i][k] - points[j][k];
                    tmp += diff * diff;
                }
                
                double distance = Math.sqrt(tmp);
                
                // Check if the distance is an integer (using a small epsilon for floating point safety, 
                // although direct comparison with floor/round is often sufficient if inputs are integers)
                if (distance == Math.floor(distance)) {
                    count++;
                }
            }
        }

        System.out.println(count);
        scanner.close();
    }
}