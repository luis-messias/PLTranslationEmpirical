import java.util.Scanner;

public class s486032847 {

    public static int keta(String s) {
        if (s == null || s.isEmpty()) {
            // Handle edge case if necessary, though input constraints usually prevent this
            return 0; 
        }
        
        // Convert string to sum of digits
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        
        // Recursively call keta on the sum
        return keta(String.valueOf(sum));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (scanner.hasNextLine()) {
            String N = scanner.nextLine();
            
            // Calculate keta(N)
            int result = keta(N);
            
            // Check the condition: keta(N) % 9 == 0
            if (result % 9 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
        scanner.close();
    }
}