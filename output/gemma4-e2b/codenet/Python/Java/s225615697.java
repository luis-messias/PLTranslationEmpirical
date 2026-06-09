import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s225615697 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            a[i] = scanner.nextInt();
        }

        // Calculate m1: m1 = int(sum([a[i] * ((-1)**i) for i in range(n)]) / 2)
        long sumAlternating = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sumAlternating += a[i];
            } else {
                sumAlternating -= a[i];
            }
        }
        // m1 = sumAlternating / 2 (integer division handles the truncation like Python's int() on float division)
        int m1 = (int) (sumAlternating / 2);

        // Initialize array m
        int[] m = new int[n];
        m[0] = m1;

        // Calculate m[i] for i > 0: m[i] = a[i-1] - m[i-1]
        for (int i = 1; i < n; i++) {
            m[i] = a[i - 1] - m[i - 1];
        }

        // Print the result: ' '.join([str(x*2) for x in m])
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(2 * m[i]);
            if (i < n - 1) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());

        scanner.close();
    }
}