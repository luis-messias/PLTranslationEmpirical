import java.util.Scanner;

public class atcoder_ABC143_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line containing A and B
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Split the line by whitespace and parse to integers
            String[] parts = line.split("\\s+");
            
            if (parts.length >= 2) {
                int A = Integer.parseInt(parts[0]);
                int B = Integer.parseInt(parts[1]);
                
                // Calculate ans = A - 2 * B
                int ans = A - 2 * B;
                
                // if ans < 0: ans = 0
                if (ans < 0) {
                    ans = 0;
                }
                
                // print ans
                System.out.println(ans);
            }
        }
        
        scanner.close();
    }
}