import java.util.Scanner;
import java.lang.Math;

public class codeforces_596_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the sequence r
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input ends prematurely
                return;
            }
            r[i] = scanner.nextInt();
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Calculate ans
        // ans = abs(r[0])
        long ans = Math.abs(r[0]);

        // for i in range(1, n): ans += abs(r[i] - r[i - 1])
        for (int i = 1; i < n; i++) {
            ans += Math.abs(r[i] - r[i - 1]);
        }

        System.out.println(ans);
    }
}