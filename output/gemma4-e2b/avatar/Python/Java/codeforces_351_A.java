import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_351_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the array elements
        List<Double> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextDouble()) break;
            arr.add(scanner.nextDouble());
        }

        // Calculate fractional parts and filter/sort
        List<Double> fractionalParts = new ArrayList<>();
        for (double x : arr) {
            double fractional = x - Math.floor(x);
            // Check if the fractional part is non-zero (handling floating point comparison)
            if (Math.abs(fractional) > 1e-9) {
                fractionalParts.add(fractional);
            }
        }

        Collections.sort(fractionalParts);

        // Calculate o
        int len_arr = fractionalParts.size();
        int o = 2 * n - len_arr;

        // Calculate arr_sum
        double arr_sum = 0;
        for (double p : fractionalParts) {
            arr_sum += p;
        }

        // Calculate res
        double res = 2e9; // 2 * 10^9

        // Loop for finding the minimum difference
        for (int i = 0; i <= n; i++) {
            if (i + o >= n) {
                res = Math.min(res, Math.abs(i - arr_sum));
            }
        }

        // Print result formatted to 3 decimal places
        System.out.printf("%.3f%n", res);
    }
}