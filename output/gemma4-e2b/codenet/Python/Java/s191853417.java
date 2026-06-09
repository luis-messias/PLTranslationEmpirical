import java.util.Scanner;

public class s191853417 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the five integers a, b, c, d, e
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        // Calculate 15 - a - b - c - d - e and print the result
        System.out.println(15 - a - b - c - d - e);
        
        scanner.close();
    }
}