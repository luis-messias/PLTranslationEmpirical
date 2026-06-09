import java.util.Scanner;

public class codeforces_622_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n. Using long to prevent potential overflow during calculations.
        long n = scanner.nextLong();
        scanner.close();

        long l = 1;
        long r = n;

        // Binary search to find the smallest k such that T_k >= n
        while (l < r) {
            // mid = l + (r - l) / 2
            long mid = l + (r - l) / 2;

            // idxcnt = mid * (mid + 1) / 2. Use long multiplication.
            long idxcnt = mid * (mid + 1) / 2;

            if (idxcnt < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // At this point, l = r = k (smallest k such that T_k >= n)

        // l -= 1
        l = l - 1;

        // idxcnt = l * (l + 1) / 2. This calculates T_{k-1}.
        long idxcnt = l * (l + 1) / 2;

        // Print n - T_{k-1}
        System.out.println(n - idxcnt);
    }
}