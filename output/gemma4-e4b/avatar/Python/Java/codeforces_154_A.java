import java.util.Scanner;
import java.lang.Math;

public class codeforces_154_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read s
        String s = scanner.nextLine();

        // Read n
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading n

        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Read x
            String x = scanner.nextLine();
            
            int a = 0;
            int b = 0;

            // Iterate over characters in s
            for (char j : s.toCharArray()) {
                char char0 = x.charAt(0);
                char char1 = x.charAt(1);

                if (j == char0) {
                    a += 1;
                } else if (j == char1) {
                    b += 1;
                } else {
                    // ans = ans + min(a, b)
                    ans += Math.min(a, b);
                    // a, b = 0, 0
                    a = 0;
                    b = 0;
                }
            }
            
            // ans = ans + min(a, b) (after loop finishes)
            ans += Math.min(a, b);
        }

        System.out.println(ans);
        
        scanner.close();
    }
}