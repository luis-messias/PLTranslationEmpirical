import java.util.Scanner;

public class atcoder_ABC142_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Reading n, equivalent to n = next_int()
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        int t = 0;
        
        // Loop from i = 0 to n-1
        for (int i = 0; i < n; i++) {
            // Check if i + 1 is odd: (i + 1) & 1 == 1
            if (((i + 1) & 1) == 1) {
                t++;
            }
        }
        
        // Calculate t / n using floating point division
        double result = (double) t / n;
        System.out.println(result);
        
        scanner.close();
    }
}