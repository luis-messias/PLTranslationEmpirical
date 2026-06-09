import java.util.Scanner;

public class atcoder_AGC002_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the line containing a and b (equivalent to LI() reading input)
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            
            if (parts.length >= 2) {
                try {
                    int a = Integer.parseInt(parts[0]);
                    int b = Integer.parseInt(parts[1]);

                    if (a > 0) {
                        System.out.println("Positive");
                    } else if (a <= 0 && b >= 0) {
                        System.out.println("Zero");
                    } else {
                        // This branch executes if a <= 0 and b < 0
                        if ((a + b) % 2 == 0) {
                            System.out.println("Negative");
                        } else {
                            System.out.println("Positive");
                        }
                    }
                } catch (NumberFormatException e) {
                    // Handle case where input is not valid integers, though typically assumed valid in competitive programming context
                }
            }
        }
        scanner.close();
    }
}