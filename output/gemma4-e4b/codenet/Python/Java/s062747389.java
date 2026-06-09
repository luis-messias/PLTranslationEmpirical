import java.util.Scanner;

public class s062747389 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read two integers from the input line
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            int result;
            
            if (a == b) {
                result = a + b;
            } else {
                // max(a, b) * 2 - 1
                int maxVal = Math.max(a, b);
                result = maxVal * 2 - 1;
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}