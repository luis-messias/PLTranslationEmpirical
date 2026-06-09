import java.util.Scanner;

public class atcoder_ABC174_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read k
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int k = scanner.nextInt();
        
        // t must be long to prevent overflow
        long t = 0;
        
        boolean found = false;
        
        for (int i = 1; i <= k; i++) {
            // t = ( t % k ) * 10 + 7
            // We must ensure the calculation uses long arithmetic
            t = (t % k) * 10 + 7;
            
            if (t % k == 0) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        
        // Equivalent to the Python for...else structure
        if (!found) {
            System.out.println(-1);
        }
        
        scanner.close();
    }
}