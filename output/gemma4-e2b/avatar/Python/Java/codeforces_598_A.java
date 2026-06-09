import java.util.Scanner;

public class codeforces_598_A {

    public static int solve(int n) {
        // s = (1 + n) * n // 2
        int s = (n + 1) * n / 2;
        
        int t = 1;
        while (t <= n) {
            s -= 2 * t;
            t *= 2;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // t = int(input())
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            
            // Loop t times
            for (int i = 0; i < t; i++) {
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    System.out.println(solve(n));
                } else {
                    // Stop if input runs out unexpectedly
                    break;
                }
            }
        }
        
        scanner.close();
    }
}