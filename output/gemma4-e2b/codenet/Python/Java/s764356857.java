import java.util.Scanner;

public class s764356857 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read A and B from input
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int B = scanner.nextInt();

                int min = B * 10;
                int max = (B + 1) * 10 - 1;

                int ans = -1;
                
                for (int i = min; i <= max; i++) {
                    // Check if int(i * 0.08) == A
                    // In Java, casting the result of i * 0.08 to int performs truncation (equivalent to Math.floor for positive numbers)
                    if (Math.floor(i * 0.08) == A) {
                        ans = i;
                        break;
                    }
                }

                System.out.println(ans);
            }
        }
        scanner.close();
    }
}