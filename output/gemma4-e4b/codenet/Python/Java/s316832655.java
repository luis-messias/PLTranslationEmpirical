import java.util.Scanner;

public class s316832655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);
        
        // The original Python code reads three values (a, b, c) but only uses a and b.
        // The calculation is (a * b) / 2, and the result is cast to int (integer division).
        // Since Java integer division truncates, we can perform the calculation directly.
        int result = (a * b) / 2;
        System.out.println(result);
        
        scanner.close();
    }
}