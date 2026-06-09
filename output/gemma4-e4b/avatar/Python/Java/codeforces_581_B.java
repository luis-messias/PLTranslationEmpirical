import java.util.Scanner;
import java.lang.Math;

public class codeforces_581_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle insufficient input if necessary, though usually guaranteed in CP context
                break;
            }
            arr[i] = scanner.nextInt();
        }
        
        scanner.close();

        if (n == 0) {
            return;
        }

        int[] ans = new int[n];
        
        // Initialize mx with the last element
        int mx = arr[n - 1];
        
        // Iterate backwards from n-2 down to 0
        for (int i = n - 2; i >= 0; i--) {
            // ans[i] = max(0, mx - arr[i] + 1)
            ans[i] = Math.max(0, mx - arr[i] + 1);
            
            // Update mx if current element is larger
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }

        // Print the result array elements space-separated
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}