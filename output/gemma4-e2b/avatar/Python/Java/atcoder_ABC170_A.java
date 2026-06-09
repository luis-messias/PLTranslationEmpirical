import java.util.Scanner;

public class atcoder_ABC170_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the entire line of input
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            // Split the line by whitespace
            String[] tokens = line.trim().split("\\s+");
            
            // Convert tokens to integers (equivalent to list(map(int, ...)))
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }
            
            // Iterate through the array (equivalent to enumerate)
            for (int e = 0; e < a.length; e++) {
                int i = a[e];
                if (i == 0) {
                    // Print e + 1 (1-based index)
                    System.out.println(e + 1);
                    break;
                }
            }
        }
        
        scanner.close();
    }
}