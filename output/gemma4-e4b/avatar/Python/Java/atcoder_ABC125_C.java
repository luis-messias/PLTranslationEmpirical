import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class atcoder_ABC125_C {

    // Calculates the Greatest Common Divisor (GCD) of two numbers
    public static int gcd(int a, int b) {
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
     * Note: left[0] and right[n] are initialized to 0, which acts as the identity for GCD(0, x) = x.
     * @param array The input array.
     * @return An array containing {left_array, right_array}.
     */
    public static int[][] ruiseki_lr(int[] array) {
        int n = array.length;
        
        // left array size n+1
        int[] left = new int[n + 1];
        // right array size n+1
        int[] right = new int[n + 1];

        // Initialize left[0] = 0 (Identity for GCD calculation)
        left[0] = 0;

        // Calculate prefix GCDs
        for (int i = 0; i < n; i++) {
            left[i + 1] = gcd(left[i], array[i]);
        }

        // Initialize right[n] = 0 (Identity for GCD calculation