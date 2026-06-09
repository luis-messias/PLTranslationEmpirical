import java.util.Scanner;

public class s267172486 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read h and a from the input
        // Assuming input provides two space-separated integers
        if (!scanner.hasNextInt()) {
            return;
        }
        int h = scanner.nextInt();
        
        if (!scanner.hasNextInt()) {
            return;
        }
        int a = scanner.nextInt();
        
        scanner.close();

        // Calculate ans = h // a (integer division)
        int ans = h / a;
        
        // Calculate ama = h % a (modulo)
        int ama = h % a;

        // If ama != 0, increment ans
        if (ama != 0) {
            ans += 1;
        }
        
        // Print the result
        System.out.println(ans);
    }
}