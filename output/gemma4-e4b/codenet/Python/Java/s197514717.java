import java.util.Scanner;
import java.lang.Math;

public class s197514717 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Assuming the input provides three space-separated integers
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            
            // Calculate the three possible numbers
            int n1 = 10 * A + B + C;
            int n2 = 10 * B + C + A;
            int n3 = 10 * C + A + B;
            
            // Find the maximum of the three numbers
            int maxVal = Math.max(n1, Math.max(n2, n3));
            
            System.out.println(maxVal);
        }
        
        scanner.close();
    }
}