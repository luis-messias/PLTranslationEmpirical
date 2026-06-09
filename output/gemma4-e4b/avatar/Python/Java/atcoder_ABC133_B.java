import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC133_B {

    /**
     * Calculates the sum of squared differences (S) between two points.
     * S is guaranteed to be an integer (long).
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
        Scanner scanner = new Scanner(System