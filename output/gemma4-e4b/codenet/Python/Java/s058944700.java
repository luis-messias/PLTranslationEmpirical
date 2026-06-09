import java.util.Scanner;

public class s058944700 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k from a single line
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        if (!scanner.hasNextInt()) {
            return;
        }
        int k = scanner.nextInt();
        
        int ans;

        if (n > k) {
            int tmp = n % k;
            if (tmp >= k - tmp) {
                ans = k - tmp;
            } else {
                ans = tmp;
            }
        } else if (n < k) {
            if (n >= k - n) {
                ans = k - n;
            } else {
                ans = n;
            }
        } else { // n == k
            ans = 0;
        }

        System.out.println(ans);
        
        scanner.close();
    }
}