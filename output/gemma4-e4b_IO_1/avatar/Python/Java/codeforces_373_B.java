import java.util.Scanner;
import java.lang.Math;

public class codeforces_373_B {

    /**
     * Calculates the sum based on the logic provided in the Python source.
     * This function assumes the input k is non-negative.
     * @param k The upper limit for counting.
     * @return The calculated sum.
     */
    public static long sum(long k) {
        if (k < 0) return 0;
        
        long ret = 0;
        long pw = 10;
        long len = 1;
        
        while (true) {
            long cur = Math.min(pw - 1, k);
            long prev = pw / 10;
            
            // Calculation: ret += (cur - prev + 1) * len
            ret += (cur - prev + 1) * len;
            
            // Break condition: if (pw - 1 >= k)
            if (pw - 1 >= k) {
                break;
            }
            
            // Update for next iteration
            len++;
            
            // Check for potential overflow before multiplication
            // Since k <= 10^18, pw will not exceed 10^19, which fits in long.
            // We only need to check if the next multiplication overflows.
            if (pw > Long.MAX_VALUE / 10) {
                break; 
            }
            pw *= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read W, M, K as long since they can reach 10^18
        long w = scanner.nextLong();
        long m = scanner.nextLong();
        long k = scanner.nextLong();
        
        scanner.close();

        // Binary Search setup
        long lo = 0;
        // hi = 1e18 (10^18)
        long hi = 1000000000000000L;
        
        while (hi - lo > 1) {
            long md = (lo + hi) / 2;
            
            // Calculate c = sum(m + md - 1) - sum(m - 1)
            long c = sum(m + md - 1) - sum(m - 1);
            
            // Check if c * k <= w. We must be careful about potential overflow when calculating c * k.
            // Since w, c, and k are positive, we can check if c * k > w by checking c > w / k (if k > 0).
            // Given the constraints, w is up to 10^18, and c*k can exceed Long.MAX_VALUE if we are not careful.
            // However, since we are comparing c*k <= w, and w <= 10^18, if c*k overflows, it must be > w.
            
            boolean condition;
            if (k == 0) {
                condition = (w >= 0); // Always true since w >= 0
            } else if (c > w / k) {
                // c * k > w (or overflowed past w)
                condition = false;
            } else {
                // c * k <= w
                condition = true;
            }

            if (condition) {
                lo = md;
            } else {
                hi = md;
            }
        }
        System.out.println(lo);
    }
}
