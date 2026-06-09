import java.util.Scanner;

public class codeforces_651_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read x and y from input, assuming they are provided on the same line separated by space
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int y = scanner.nextInt();
                
                // Calculate the expression: max(x + y - 3 + ((y - x) % 3 > 0), 0)
                // In Java, boolean expressions are converted to 1 (true) or 0 (false) in arithmetic operations.
                int condition = (y - x) % 3 > 0 ? 1 : 0;
                int value = x + y - 3 + condition;
                
                int result = Math.max(value, 0);
                
                System.out.println(result);
            }
        }
        scanner.close();
    }
}