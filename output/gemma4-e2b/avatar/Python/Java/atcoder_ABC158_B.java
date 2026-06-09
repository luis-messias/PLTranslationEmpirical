import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC158_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, A, B from the input line
        if (scanner.hasNextLong()) {
            long N = scanner.nextLong();
            long A = scanner.nextLong();
            long B = scanner.nextLong();

            // Python logic translation
            // mod = 10**9 + 7 (not used in calculation)
            
            long ans = 0;
            
            // rep = N // (A + B)
            long sum_AB = A + B;
            long rep = N / sum_AB;
            
            // ans += rep * A
            ans += rep * A;
            
            // res = N - rep * (A + B)
            long res = N - rep * sum_AB;
            
            // ans += min(res, A)
            ans += Math.min(res, A);
            
            System.out.println(ans);
        }

        scanner.close();
    }
}