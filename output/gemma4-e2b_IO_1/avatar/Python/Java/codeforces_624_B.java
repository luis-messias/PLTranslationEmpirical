import java.util.Scanner;
import java.util.Arrays;

public class codeforces_624_B {
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
            if (scanner.hasNextInt()) {
                a[i] = scanner.nextInt();
            }
        }

        // Sort A in reverse order (descending)
        Arrays.sort(a); // Sorts ascending
        
        // Reverse the sort to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }

        // Initialize variables
        // pre corresponds to float('inf'). We use Long.MAX_VALUE as a large starting point.
        long pre = Long.MAX_VALUE; 
        long ans = 0;

        for (int j = 0; j < n; j++) {
            long current_a = a[j];
            
            // Calculate the term: min(pre - 1, a[j])
            // Since pre is Long.MAX_VALUE, pre - 1 is safe.
            long term = Math.min(pre - 1, current_a);
            
            // ans += max(0, term)
            ans += Math.max(0, term);
            
            // pre = max(0, term)
            pre = Math.max(0, term);
        }

        System.out.println(ans);
        
        scanner.close();
    }
}
