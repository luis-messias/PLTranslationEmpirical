import java.util.Scanner;

public class codeforces_546_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read k, n, w from standard input
        if (!scanner.hasNext()) {
            return;
        }
        
        // Use long to safely handle potential large numbers in calculations
        long k = Long.parseLong(scanner.next());
        long n = Long.parseLong(scanner.next());
        long w = Long.parseLong(scanner.next());
        
        scanner.close();

        // Check constraints: 1 <= k and w <= 1000
        // Note: The Python code implicitly requires w >= 1 because the loop starts at 1.
        if (k >= 1 && w >= 1 && w <= 1000) {
            // Calculate total = k * (1 + 2 + ... + w)
            // Sum of 1 to w = w * (w + 1) / 2
            
            // Calculate sum_1_to_w using long arithmetic
            long sum_1_to_w = w * (w + 1) / 2;
            long total = k * sum_1_to_w;
            
            // Calculate the difference: total - n
            long difference = total - n;
            
            // Output max(0, total - n)
            if (difference > 0) {
                System.out.println(difference);
            } else {
                System.out.println(0);
            }
        }
        // If constraints are not met, the original Python code prints nothing, so we do nothing here.
    }
}