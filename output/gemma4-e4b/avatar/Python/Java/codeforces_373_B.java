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
            
            // Check for potential overflow before multiplication, though k <= 10^18 
            // suggests pw won't exceed Long.MAX_VALUE significantly before the break condition hits.
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
        // hi = 1e18
        long hi = 100000000000000