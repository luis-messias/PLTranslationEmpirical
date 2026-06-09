import java.util.Scanner;

public class atcoder_ABC172_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N (equivalent to N = ri())
        if (!scanner.hasNextLong()) {
            return;
        }
        long N = scanner.nextLong();
        
        long ans = 0;
        
        // Loop from i = 1 to N
        for (long i = 1; i <= N; i++) {
            // Calculate k = N // i (integer division)
            long k = N / i;
            
            // Calculate the term: i * k * (k + 1) / 2
            // We calculate k * (k + 1) / 2 first to ensure intermediate results fit in long
            long sum_k = k * (k + 1) / 2;
            
            long term = i * sum_k;
            
            ans += term;
        }
        
        System.out.println(ans);
        
        scanner.close();
    }
}