import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC158_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N, A, B from a single line of input
        long N = scanner.nextLong();
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        
        // The modulo constant is defined but unused in the calculation
        // long mod = 1000000007L; 
        
        long ans = 0;
        
        // Calculate rep = N // (A + B)
        long divisor = A + B;
        long rep = N / divisor;
        
        // ans += rep * A
        ans = rep * A;
        
        // Calculate res = N - rep * (A + B)
        long res = N - rep * divisor;
        
        // ans += min(res, A)
        ans += Math.min(res, A);
        
        System.out.println(ans);
        
        scanner.close();
    }
}