import java.util.Scanner;

public class s960572618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");

        if (parts.length < 3) {
            // Handle case where input might not have enough elements, though based on the Python logic, 
            // we assume valid input structure for simplicity.
            return; 
        }

        String a = parts[0];
        String b = parts[1];
        String c = parts[2];

        if (a.equals(b) && b.equals(c)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}