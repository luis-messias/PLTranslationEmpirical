import java.util.Scanner;

public class s537584449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input a
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            
            int digitsSum = 0;
            int temp = a;
            
            // Calculate the sum of digits
            // Note: The Python logic handles the case where a=0 implicitly (loop doesn't run, result=0).
            // If a=0, digitsSum=0. 0 != 1, prints 0.
            while (temp != 0) {
                digitsSum += temp % 10;
                temp = temp / 10;
            }
            
            // Apply the conditional printing logic
            if (digitsSum == 1) {
                System.out.println("10");
            } else {
                System.out.println(digitsSum);
            }
        }
        
        scanner.close();
    }
}