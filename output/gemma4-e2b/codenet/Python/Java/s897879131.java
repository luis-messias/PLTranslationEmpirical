import java.util.Scanner;

public class s897879131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read R, G, B, N
        // Using long to safely handle potentially large numbers
        long R = scanner.nextLong();
        long G = scanner.nextLong();
        long B = scanner.nextLong();
        long N = scanner.nextLong();

        long score = 0;

        // i ranges from 0 up to N/R
        for (long i = 0; i * R <= N; i++) {
            long remaining_N_after_i = N - i * R;
            
            // j ranges from 0 up to (N - i*R) / G
            for (long j = 0; j * G <= remaining_N_after_i; j++) {
                long current_remainder = remaining_N_after_i - j * G;
                
                // Check if (N - i*R - j*G) is divisible by B
                // Since the loop bounds ensure current_remainder >= 0, we only check the modulo.
                if (current_remainder % B == 0) {
                    score++;
                }
            }
        }

        System.out.println(score);
        scanner.close();
    }
}