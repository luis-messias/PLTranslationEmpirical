import java.util.Scanner;
import java.lang.Math;

public class atcoder_AGC019_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read q, h, s, d (MAP)
        // The Python code reads 4 values first, then n.
        if (!scanner.hasNextLong()) return;
        long q = scanner.nextLong();
        if (!scanner.hasNextLong()) return;
        long h = scanner.nextLong();
        if (!scanner.hasNextLong()) return;
        long s = scanner.nextLong();
        if (!scanner.hasNextLong()) return;
        long d = scanner.nextLong();

        // Read n (INT)
        if (!scanner.hasNextLong()) return;
        long n = scanner.nextLong();

        // best1L = min(q * 4, h * 2, s)
        long term1 = Math.min(q * 4, h * 2);
        long best1L = Math.min(term1, s);
        
        // best2L = min(d, best1L * 2)
        long best2L = Math.min(d, best1L * 2);

        long result;
        
        // if n % 2 == 0 :
        if (n % 2 == 0) {
            // print ( best2L * ( n // 2 ) )
            result = best2L * (n / 2);
        } else {
            // else :
            // print ( best2L * ( n // 2 ) + best1L )
            result = best2L * (n / 2) + best1L;
        }

        System.out.println(result);
        
        scanner.close();
    }
}
