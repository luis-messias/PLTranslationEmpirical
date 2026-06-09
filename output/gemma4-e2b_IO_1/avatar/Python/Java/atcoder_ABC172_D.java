import java.util.Scanner;

public class atcoder_ABC172_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            long ans = 0;
            
            // Calculate the sum: ans += i * ( N // i ) * ( N // i + 1 ) // 2
            for (int i = 1; i <= N; i++) {
                long k = N / i;
                // Calculate i * k * (k + 1) / 2
                // Use long for intermediate calculation to prevent overflow
                long term = (long)i * k * (k + 1) / 2;
                ans += term;
            }
            System.out.println(ans);
        }
    }
}
