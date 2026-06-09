import java.util.Scanner;
import java.util.Arrays;

class Solution {

    // GCD function (Euclidean algorithm)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // ruiseki_lr function
    public static int[] ruiseki_lr(int[] array) {
        int n = array.length;
        // left and right arrays are size n+1, initialized to 0 (or some default value)
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        // Initialize with 0s (default for int array in Java)
        // Note: In Python, e=0. Java initializes int arrays to 0.

        // Calculate prefix GCDs (left[i] = gcd(array[0]...array[i-1]))
        // left[0] remains 0
        for (int i = 0; i < n; i++) {
            left[i + 1] = gcd(left[i], array[i]);
        }

        // Calculate suffix GCDs (right[i] = gcd(array[i