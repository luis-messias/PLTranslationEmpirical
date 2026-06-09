import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC133_B {

    /**
     * Calculates the sum of squared differences (S) between two points.
     * S is guaranteed to be a long.
     */
    private static long distSq(int[] x, int[] y, int d) {
        long sum = 0;
        for (int i = 0; i < d; i++) {
            // Calculate difference using long to prevent overflow before squaring
            long diff = (long)x[i] - y[i];
            sum += diff * diff;
        }
        return sum;
    }

    /**
     * Checks if a number S is a perfect square. 
     * If it is, the distance sqrt(S) is an integer.
     */
    private static boolean isPerfectSquare(long s) {
        if (s < 0) return false;
        if (s == 0) return true;
        
        // Calculate the integer square root approximation
        // Math.sqrt returns double. We round it to the nearest long integer.
        long root = (long) Math.round(Math.sqrt(s));
        
        // Check if root * root equals s.
        return root * root == s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and D
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        
        // Read points
        int[][] points = new int[n][d];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                if (!scanner.hasNextInt()) {
                    // Handle unexpected end of input if necessary
                    return;
                }
                points[i][j] = scanner.nextInt();
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate squared distance
                long s = distSq(points[i], points[j], d);
                
                // Check if the distance is an integer
                if (isPerfectSquare(s)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
        scanner.close();
    }
}
