import java.util.Scanner;

public class codeforces_581_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input line (e.g., "10 20")
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            if (parts.length == 2) {
                try {
                    int a = Integer.parseInt(parts[0]);
                    int b = Integer.parseInt(parts[1]);
                    
                    int minVal = Math.min(a, b);
                    int maxVal = Math.max(a, b);
                    
                    // Calculate (max - min) // 2
                    int result = (maxVal - minVal) / 2;
                    
                    // Print min and the calculated value
                    System.out.println(minVal + " " + result);
                } catch (NumberFormatException e) {
                    // Handle case where input parts are not valid integers
                    // In a strict translation context, we might skip this, but for robustness:
                }
            }
        }
        scanner.close();
    }
}