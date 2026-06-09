import java.util.Scanner;

public class s702834515 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        
        // r stores the sum, using long to prevent potential integer overflow
        long r = 0;
        
        // Loop from ii = 0 up to n-1
        for (int ii = 0; ii < n; ii++) {
            int i = ii + 1; // The number being checked (1 to n)
            
            // Check if i is not divisible by 3 AND not divisible by 5
            if (i % 3 != 0 && i % 5 != 0) {
                r += i;
            }
        }
        
        System.out.println(r);
        
        scanner.close();
    }
}