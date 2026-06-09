import java.util.Scanner;
import java.util.Arrays;

public class codeforces_581_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            arr[i] = scanner.nextInt();
        }

        // Initialize ans array
        int[] ans = new int[n];
        
        if (n > 0) {
            // Initialize mx with the last element
            int mx = arr[n - 1];
            
            // The loop iterates from n-2 down to 0
            for (int i = n - 2; i >= 0; i--) {
                // ans[i] = max(0, mx - arr[i] + 1)
                ans[i] = Math.max(0, mx - arr[i] + 1);
                
                // if arr[i] > mx: mx = arr[i]
                if (arr[i] > mx) {
                    mx = arr[i];
                }
            }
        }
        
        // Print the result array ans
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + (i == n - 1 ? "" : " "));
        }
        System.out.println();
        
        scanner.close();
    }
}
