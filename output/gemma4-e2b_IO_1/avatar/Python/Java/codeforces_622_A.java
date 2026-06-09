import java.util.Scanner;

public class codeforces_622_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        int l = 1;
        int r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;
            // Calculate sum of 1 to mid: mid * (mid + 1) / 2
            // Use long for intermediate calculation if n is large, but since n is int, mid is int, 
            // and the result fits in int if n is up to 2*10^9.
            int idxcnt = mid * (mid + 1) / 2;
            
            if (idxcnt < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // l is the largest integer such that S_l <= n (or slightly adjusted based on the loop termination)
        // The Python code does l -= 1 immediately after the loop.
        l -= 1;
        
        // Calculate the sum for the adjusted l
        int idxcnt = l * (l + 1) / 2;
        
        // Print n - idxcnt
        System.out.println(n - idxcnt);
    }
}
