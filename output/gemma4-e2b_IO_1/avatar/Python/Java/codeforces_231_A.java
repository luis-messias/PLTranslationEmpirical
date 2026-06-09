import java.util.Scanner;

public class codeforces_231_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (the number of subsequent lines to process)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        int c = 0;

        // Loop n times to process n lines of input
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Parse the space-separated integers
                String[] parts = line.trim().split("\\s+");
                
                long sum = 0;
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        // Assuming input consists of valid integers
                        sum += Long.parseLong(part);
                    }
                }

                // Check the condition: sum > 1
                if (sum > 1) {
                    c++;
                }
            }
        }

        System.out.println(c);
        scanner.close();
    }
}
