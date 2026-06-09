import java.util.Scanner;

public class s694958625 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read x
        int x = scanner.nextInt();
        
        // Read a
        int a = scanner.nextInt();
        
        // Read b
        int b = scanner.nextInt();
        
        // Calculate (x - a) % b
        int result = (x - a) % b;
        
        // Print the result
        System.out.println(result);
        
        scanner.close();
    }
}