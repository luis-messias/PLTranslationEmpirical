import java.util.Scanner;

public class s960572618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input line
        String line = scanner.nextLine();
        
        // Split the line by whitespace
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length >= 3) {
            String a = parts[0];
            String b = parts[1];
            String c = parts[2];
            
            if (a.equals(b) && b.equals(c)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}