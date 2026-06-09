import java.util.Scanner;

public class s590045523 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        
        // Read L
        int[] L = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input might terminate early
                return;
            }
            L[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        long ans = 0;
        
        // Iterate through all unique triplets (i, j, k) such that i < j < k
        for (int i = 0; i <= N - 3; i++) {
            for (int j = i + 1; j <= N - 2; j++) {
                for (int k = j + 1; k <= N - 1; k++) {
                    int a = L[i];
                    int b = L[j];
                    int c = L[k];
                    
                    // Condition 1: Check for distinct elements
                    if (a == b || b == c || c == a) {
                        continue;
                    }
                    
                    // Condition 2: Triangle inequality check
                    // Use long casting for sums to prevent potential integer overflow, 
                    // although standard constraints usually keep sums within int range.
                    if ((long)a + b > c && 
                        (long)b + c > a && 
                        (long)c + a > b) {
                        
                        ans++;
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}