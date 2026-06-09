import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC125_C {

    // Calculates the Greatest Common Divisor (GCD) of two numbers
    public static int gcd(int a, int b) {
        // Ensure positive inputs for standard Euclidean algorithm, though the logic handles signs implicitly
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calculates prefix and suffix GCD arrays.
     * left[i] stores GCD(array[0]...array[i-1])
     * right[i] stores GCD(array[i]...array[n-1])
     * @param array The input array.
     * @return An array containing {left_array, right_array}.
     */
    public static int[][] ruiseki_lr(int[] array) {
        int n = array.length;
        
        // left array size n+1
        int[] left = new int[n + 1];
        // right array size n+1
        int[] right = new int[n + 1];

        // left[0] = 0 acts as the identity for GCD calculation: gcd(0, x) = x
        left[0] = 0;

        // Calculate prefix GCDs
        for (int i = 0; i < n; i++) {
            left[i + 1] = gcd(left[i], array[i]);
        }

        // right[n] = 0 acts as the identity for GCD calculation
        right[n] = 0;

        // Calculate suffix GCDs
        for (int i = n - 1; i >= 0; i--) {
            right[i] = gcd(right[i + 1], array[i]);
        }
        
        // Return {left_array, right_array}
        return new int[][]{left, right};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Read array A
        int[] a = new int[n];
