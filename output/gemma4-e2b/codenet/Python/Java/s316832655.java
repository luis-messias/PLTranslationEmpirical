import java.util.Scanner;

public class s316832655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read a, b, and c from the input line
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // Read c (though it is unused in the calculation)
        scanner.nextInt(); 
        
        // Calculate (a * b) / 2 and print the result
        int result = (a * b) / 2;
        System.out.println(result);
    }
}