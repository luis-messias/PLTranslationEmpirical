import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class s777789287 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m (assuming they are on the first line)
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        scanner.close();

        // Convert int[] to Integer[] to allow reverse sorting
        Integer[] boxedA = new Integer[n];
        for (int i = 0; i < n; i++) {
            boxedA[i] = a[i];
        }

        // Sort in descending order
        Arrays.sort(boxedA, Collections.reverseOrder());

        // Calculate the sum of elements
        long sum = 0;
        for (Integer val : boxedA) {
            sum += val;
        }

        // Calculate s = sum(a) / (4 * m)
        // Use 4.0 to ensure floating point division
        double s = (double) sum / (4.0 * m);

        // Check the condition: a[m-1] >= s
        // Since m is 1-indexed rank, the element is at index m-1
        if (boxedA[m - 1] >= s) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}