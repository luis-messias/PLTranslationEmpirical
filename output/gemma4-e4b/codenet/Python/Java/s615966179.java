import java.util.Scanner;
import java.lang.Math;

public class s615966179 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n, a, b. Using long to prevent potential overflow.
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        // ans = n // (a + b) * a
        long ans = (n / (a + b)) * a;
        
        // r = min(n % (a + b), a)
        long r = Math.min(n % (a + b), a);
        
        // ans += r
        ans += r;
        
        System.out.println(ans);
        
        scanner.close();
    }
}