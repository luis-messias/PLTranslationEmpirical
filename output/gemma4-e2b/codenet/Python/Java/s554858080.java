import java.util.Scanner;

public class s554858080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the entire line of input
        String line = scanner.nextLine();
        
        // The Python logic effectively concatenates all space-separated parts into one number.
        // We split the line by whitespace and then join the resulting strings.
        String[] parts = line.split("\\s+");
        
        // Concatenate the parts to form the number string
        String numStr = String.join("", parts);
        
        // Convert the concatenated string to an integer
        // Note: If the input is very long, it might exceed standard int/long limits, 
        // but we follow the direct translation of the Python logic.
        long num = Long.parseLong(numStr);
        
        // Check the condition
        if (num % 4 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}