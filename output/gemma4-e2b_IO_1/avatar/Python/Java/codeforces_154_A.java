import java.util.Scanner;
import java.lang.Math;

public class codeforces_154_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // s = input()
        String s = scanner.nextLine();

        // n = int(input())
        int n = Integer.parseInt(scanner.nextLine());

        // ans = 0
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // x = input()
            String x = scanner.nextLine();

            // a, b = 0, 0
            int a = 0;
            int b = 0;

            // Iterate through s
            for (int j = 0; j < s.length(); j++) {
                char current_char = s.charAt(j);
                
                // Check against x[0] and x[1]
                if (current_char == x.charAt(0)) {
                    a++;
                } else if (current_char == x.charAt(1)) {
                    b++;
                } else {
                    ans += Math.min(a, b);
                    a = 0;
                    b = 0;
                }
            }
            
            // ans = ans + min(a, b) after the inner loop
            ans += Math.min(a, b);
        }

        // print(ans)
        System.out.println(ans);
        
        scanner.close();
    }
}
