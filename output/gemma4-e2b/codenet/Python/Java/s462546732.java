import java.util.Scanner;

public class s462546732 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the entire line of input
        String line = scanner.nextLine();
        
        // Split the line by space
        String[] parts = line.split(" ");
        
        // Parse a and b
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        
        // Apply the logic
        if (a <= b) {
            System.out.println(a);
        } else {
            System.out.println(a - 1);
        }
    }
}