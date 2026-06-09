import java.util.Scanner;

public class codeforces_231_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        int c = 0;

        // Loop n times
        for (int i = 0; i < n; i++) {
            // Read the line of space-separated integers
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Parse the line to get integers
                String[] parts = line.trim().split("\\s+");
                
                long sum = 0;
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        try {
                            sum += Long.parseLong(part);
                        } catch (NumberFormatException e) {
                            // Ignore non-integer parts if any, though input is expected to be integers
                        }
                    }
                }

                // Check the condition
                if (sum > 1) {
                    c = c + 1;
                }
            }
        }

        System.out.println(c);
        scanner.close();
    }
}