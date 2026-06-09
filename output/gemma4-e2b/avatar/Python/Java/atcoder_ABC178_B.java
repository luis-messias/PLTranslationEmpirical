import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC178_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // LI() reads a, b, c, d
        if (scanner.hasNextLong()) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long d = scanner.nextLong();
            
            // Calculate max(a*c, b*d, a*d, b*c)
            long ac = a * c;
            long bd = b * d;
            long ad = a * d;
            long bc = b * c;
            
            long result = Math.max(ac, Math.max(bd, Math.max(ad, bc)));
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}