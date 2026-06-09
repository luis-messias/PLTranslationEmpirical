import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and x
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int x = scanner.nextInt();
        
        // Read array a
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        
        long cnt = 0;

        // Loop from i = 1 to N-1
        for (int i = 1; i < N; i++) {
            int tmp = a[i - 1] + a[i];
            
            if (tmp > x) {
                int excess = tmp - x;
                cnt += excess;
                
                // Apply modifications to a
                if (excess > a[i]) {
                    // Case 1: excess > a[i]
                    a[i - 1] = excess - a[i];
                    a[i] = 0;
                } else {
                    // Case 2: excess <= a[i]
                    a[i] = a[i] - excess;
                }
            }
        }
        
        System.out.println(cnt);
        scanner.close();
    }
}