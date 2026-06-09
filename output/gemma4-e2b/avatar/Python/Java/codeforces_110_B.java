import java.util.Scanner;

public class codeforces_110_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the integer n
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            String LUCKY = "abcd";
            StringBuilder s = new StringBuilder();
            
            // Loop n times and build the string
            for (int i = 0; i < n; i++) {
                // Get the character based on the cycling pattern
                s.append(LUCKY.charAt(i % 4));
            }
            
            System.out.println(s.toString());
        }
        
        scanner.close();
    }
}