import java.util.Scanner;

public class s897879131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read R, G, B, N from a single line of input
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int R = scanner.nextInt();
        int G = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        
        int score = 0;
        
        // Iterate through possible counts of R (i)
        // i * R must be <= N
        for (int i = 0; i * R <= N; i++) {
            int remainingAfterR = N - i * R;
            
            // Iterate through possible counts of G (j)
            // j * G must be <= remainingAfterR
            for (int j = 0; j * G <= remainingAfterR; j++) {
                int remaining = remainingAfterR - j * G;
                
                // Check if the remaining amount is divisible by B
                if (remaining % B == 0) {
                    score++;
                }
            }
        }
        
        System.out.println(score);
        
        scanner.close();
    }
}