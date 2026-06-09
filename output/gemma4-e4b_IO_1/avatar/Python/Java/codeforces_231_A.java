import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        // Read N
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading n
        scanner.nextLine(); 
        
        int c = 0;
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            
            if (line.trim().isEmpty()) {
                continue;
            }
            
            // Split by one or more whitespace characters
            String[] tokens = line.trim().split("\\s+");
            long sum = 0;
            
            // Calculate sum
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    // Assuming valid integer input
                    sum += Integer.parseInt(token);
                }
            }
            
            if (sum > 1) {
                c++;
            }
        }
        
        System.out.println(c);
        scanner.close();
    }
}
