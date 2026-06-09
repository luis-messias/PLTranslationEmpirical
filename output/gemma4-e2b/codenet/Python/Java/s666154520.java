import java.util.Scanner;

public class s666154520 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            // The loop limit is 10^5. We use long for i*i comparison to prevent potential overflow, 
            // although n is only up to 10^5.
            for (int i = 1; i < 100000; i++) {
                long i_long = i;
                if (i_long * i_long > n) {
                    System.out.println((i_long - 1) * (i_long - 1));
                    return; // Equivalent to exit()
                }
            }
        }
    }
}