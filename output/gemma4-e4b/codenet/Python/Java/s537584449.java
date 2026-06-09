import java.util.Scanner;

public class s537584449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input 'a'
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int a = scanner.nextInt();
        scanner.close();

        // Calculate the sum of digits
        int sum = 0;
        int temp = a;
        
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        
        // Apply the conditional printing logic
        if (sum == 1) {
            System.out.println("10");
        } else {
            System.out.println(sum);
        }
    }
}