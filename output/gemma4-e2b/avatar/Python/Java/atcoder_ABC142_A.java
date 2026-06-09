import java.util.Scanner;

public class atcoder_ABC142_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n (equivalent to next_int())
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int t = 0;
            
            // Loop equivalent to the Python logic: for i in range(n): if (i + 1) is odd: t += 1
            for (int i = 0; i < n; i++) {
                // Check if i + 1 is odd. (i + 1) & 1 is true if i + 1 is odd.
                if ((i + 1) & 1 == 1) {
                    t += 1;
                }
            }
            
            // Print t / n (integer division)
            System.out.println(t / n);
        }
        
        scanner.close();
    }
}