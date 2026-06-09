import java.util.Scanner;
import java.lang.Math;

public class s923405856 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            // Read N, the count of elements
            int n = scanner.nextInt();
            
            if (n == 0) {
                break;
            }
            
            // Initialize res (overall max sum) and s (current max sum ending here)
            // Using long to prevent potential integer overflow during summation.
            long res = Long.MIN_VALUE; 
            long s = 0;
            
            for (int i = 0; i < n; i++) {
                // Read the element 'a'
                long a = scanner.nextLong(); 
                
                // s = max(s + a, a)
                s = Math.max(s + a, a);
                
                // res = max(s, res)
                res = Math.max(s, res);
            }
            
            System.out.println(res);
        }
        scanner.close();
    }
}