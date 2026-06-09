import java.util.Scanner;

public class s199418121 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the entire line of input
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            if (parts.length == 2) {
                // A is the first part
                String A_str = parts[0];
                
                // B is the second part
                String B_str = parts[1];
                
                try {
                    // A = int(A)
                    int A = Integer.parseInt(A_str);
                    
                    // B = int(B.replace(".", ""))
                    String B_cleaned = B_str.replace(".", "");
                    int B = Integer.parseInt(B_cleaned);
                    
                    // print(A * B // 100)
                    // Integer division in Java handles the // operator
                    long result = (long)A * B / 100;
                    
                    System.out.println(result);
                    
                } catch (NumberFormatException e) {
                    // Handle cases where parsing fails
                    // In a strict translation context, we assume valid input based on the Python example
                }
            }
        }
        scanner.close();
    }
}