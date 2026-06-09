import java.util.Scanner;

public class s060251920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two integers from standard input
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // Calculate and print the product
            System.out.println(a * b);
        }
        
        scanner.close();
    }
}