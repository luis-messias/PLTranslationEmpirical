import java.util.Scanner;
import java.util.Arrays;

public class s146553386 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the two arrays a[0] and a[1]
        int[][] a = new int[2][n];

        // Read the first array a[0]
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                a[0][i] = scanner.nextInt();
            }
        }

        // Read the second array a[1]
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                a[1][i] = scanner.nextInt();
            }
        }

        // a[1] = a[1][::-1] (Reverse the second array)
        int[] a1 = a[1];
        for (int i = 0; i < n / 2; i++) {
            int temp = a1[i];
            a1[i] = a1[n - 1 - i];
            a1[n - 1 - i] = temp;
        }
        a[1] = a1;


        // Calculate cumulative sums (res_0 and res_1)
        // res_0 = numpy.cumsum(a[0])
        long[] res_0 = new long[n];
        res_0[0] = a[0][0];
        for (int i = 1; i < n; i++) {
            res_0[i] = res_0[i - 1] + a[0][i];
        }

        // res_1 = numpy.cumsum(a[1])
        long[] res_1 = new long[n];
        res_1[0] = a[1][0];
        for (int i = 1; i < n; i++) {
            res_1[i] = res_1[i - 1] + a[1][i];
        }

        // Find the maximum result
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // check = res_0[i] + res_1[n-1-i]
            long check = res_0[i] + res_1[n - 1 - i];
            if (check > ans) {
                ans = check;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}