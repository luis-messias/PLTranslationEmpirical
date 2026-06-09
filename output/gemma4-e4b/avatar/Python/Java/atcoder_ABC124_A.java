import java.util.Scanner;

public class atcoder_ABC124_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read two integers a and b from standard input
        if (!scanner.hasNextInt()) {
            return;
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        int c = 0;
        
        // Loop runs 2 times
        for (int i = 0; i < 2; i++) {
            // c += max(a, b)
            int maxVal = Math.max(a, b);
            c += maxVal;
            
            // Update a or b
            if (a >= b) {
                a -= 1;
            } else {
                b -= 1;
            }
        }
        
        System.out.println(c);
        
        scanner.close();
    }
}