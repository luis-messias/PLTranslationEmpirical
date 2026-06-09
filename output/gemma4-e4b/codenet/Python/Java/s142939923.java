import java.util.Scanner;
import java.lang.Math;

public class s142939923 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // Calculate the three values: a+b, a-b, a*b
            int sum = a + b;
            int diff = a - b;
            int prod = a * b;
            
            // Find the maximum of the three values
            int maxVal = Math.max(sum, Math.max(diff, prod));
            
            System.out.println(maxVal);
        }
        
        scanner.close();
    }
}