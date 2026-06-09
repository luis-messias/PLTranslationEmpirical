import java.util.Scanner;

public class atcoder_ABC112_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read age
        int age = scanner.nextInt();
        
        if (age == 1) {
            System.out.println("Hello World");
        } else {
            // Read a and b
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            System.out.println(a + b);
        }
        
        scanner.close();
    }
}