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
    // Returns an array containing the left and right GCD arrays.
    // left[i] = GCD(array[0]...array[i-1])
    // right[i] = GCD(array[i]...array[n-1])
    public static int[][] ruiseki_lr(int[] array) {
        int n = array.length;
        
        // left and right arrays are size n+1.
        // left[0] = 0, right[n] = 0 (as per Python initialization e=0)
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        // Calculate prefix GCDs
        // left[i] stores GCD of array[0]...array[i-1]
        // left[0] = 0
        for (int i = 0; i < n; i++) {
            left[i + 1] = gcd(left[i], array[i]);
        }

        // Calculate suffix GCDs
        // right[i] stores GCD of array[i]...array[n-1]
        // right[n] = 0
        for (int i = n - 1; i >= 0; i--) {
            right[i] = gcd(right[i + 1], array[i]);
        }
        
        return new int[][]{left, right};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read array A
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                a[i] = scanner.nextInt();
            } else {
                // Handle case where input might be incomplete, though usually guaranteed in CP context
                return;
            }
        }
        
        // Calculate left and right arrays
        int[][] results = ruiseki_lr(a);
        int[] left = results[0];
        int[] right = results[1];

        // Calculate the final answer
        int ans = 0;
        // Loop runs for i from 0 to n-1
        // We compare left[i] (GCD of A[0]...A[i-1]) and right[i+1] (GCD of A[i+1]...A[n-1])
        for (int i = 0; i < n; i++) {
            // Python: ans = max ( gcd ( left [ i ] , right [ i + 1 ] ) , ans )
            int currentGcd = gcd(left[i], right[i + 1]);
            if (currentGcd > ans) {
                ans = currentGcd;
            }
        }

        System.out.println(ans);
        
        scanner.close();
    }
}
