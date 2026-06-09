import java.util.Scanner;

public class s522872163 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the line containing X and A
        String line = scanner.nextLine();
        
        // Split the line and parse the integers
        String[] parts = line.split("\\s+");
        if (parts.length == 2) {
            int X = Integer.parseInt(parts[0]);
            int A = Integer.parseInt(parts[1]);

            if (X < A) {
                System.out.println(0);
            } else {
                System.out.println(10);
            }
        }
        
        scanner.close();
    }
}