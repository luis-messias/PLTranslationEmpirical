import java.util.Scanner;

public class codeforces_598_A {

    public static long solve(long n) {
        // s = (1 + n) * n // 2
        long s = (n + 1) * n / 2;
        
        long t = 1;
        while (t <= n) {
            s -= 2 * t;
            t *= 2;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read t (number of test cases)
        if (!scanner.hasNextLong()) {
            scanner.close();
            return;
        }
        long t = scanner.nextLong();
        
        for (int i = 0; i < t; i++) {
            // Read n
            if (!scanner.hasNextLong()) {
                break;
            }
            long n = scanner.nextLong();
            
            // Calculate and print result
            System.out.println(solve(n));
        }
        
        scanner.close();
    }
}