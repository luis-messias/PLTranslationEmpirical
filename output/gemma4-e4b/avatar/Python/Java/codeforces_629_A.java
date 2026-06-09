import java.util.Scanner;

public class codeforces_629_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            // Handle case where N might not be provided
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading N

        // Read the cake structure
        String[] cake = new String[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                cake[i] = scanner.nextLine();
            } else {
                // Handle insufficient input lines
                return;
            }
        }
        scanner.close();

        double happiness = 0.0;

        // --- 1. Row Processing ---
        for (int i = 0; i < n; i++) {
            String line = cake[i];
            int chocCount = 0;
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'C') {
                    chocCount++;
                }
            }

            if (chocCount > 1) {
                // Calculate nfat = chocCount * (chocCount - 1)
                // Using long for product calculation to prevent overflow
                long nfat = (long) chocCount * (chocCount - 1);
                happiness += (double) nfat / 2.0;
            }
        }

        // --- 2. Column Processing ---
        for (int j = 0; j < n; j++) { // j is the column index
            int chocCount = 0;
            for (int i = 0; i < n; i++) { // i is the row index
                // Check if the character at (i, j) is 'C'
                if (cake[i].length() > j && cake[i].charAt(j) == 'C') {
                    chocCount++;
                }
            }

            if (chocCount > 1) {
                // Calculate nfat = chocCount * (chocCount - 1)
                long nfat = (long) chocCount * (chocCount - 1);
                happiness += (double) nfat / 2.0;
            }
        }

        // Output the integer part of happiness
        System.out.println((int) happiness);
    }
}