import java.util.Scanner;

public class s039768540 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the integer x
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            
            // Calculate the number of '3's to append (equivalent to Python's x // 100)
            int count = x / 100;
            
            // Build the string: "ai1333" followed by 'count' number of '3's
            StringBuilder result = new StringBuilder("ai1333");
            for (int i = 0; i < count; i++) {
                result.append('3');
            }
            
            System.out.println(result.toString());
        }
        scanner.close();
    }
}