import java.util.Scanner;

public class atcoder_ABC178_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // The Python code reads a single integer input 'a'
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            
            // Print 1 if a == 0, else 0
            System.out.println(a == 0 ? 1 : 0);
        }
        
        scanner.close();
    }
}