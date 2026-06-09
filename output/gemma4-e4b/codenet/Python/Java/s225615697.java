import java.util.Scanner;
import java.lang.StringBuilder;

public class s225615697 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read array A
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input ends prematurely
                return;
            }
            a[i] = scanner.nextInt();
        }
        
        scanner.close();

        // 1. Calculate the alternating sum S = a[0] - a[1] + a[2] - ...
        // Using long for sumS to prevent potential overflow during summation
        long sumS = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sumS += a[i];
            } else {
                sumS -= a[i];
            }
        }

        // 2. Calculate m1 = floor(S / 2)
        // Since sumS is an integer, integer division handles the floor operation correctly.
        int m1 = (int) (sumS / 2);

        // 3. Calculate array m
        int[] m = new int[n];
        if (n > 0) {
            m[0] = m1;
            for (int i = 1; i < n; i++) {
                // m[i] = a[i-1] - m[i-1]
                m[i] = a[i-1] - m[i-1];
            }
        }

        // 4. Output 2 * m[i] space-separated
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(m[i] * 2);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}