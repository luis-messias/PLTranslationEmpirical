import java.util.Scanner;

public class codeforces_146_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the list of numbers
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input might be incomplete
                break;
            }
            number[i] = scanner.nextInt();
        }

        // Initialization
        long h1 = 0;
        long h2 = 0;
        int x = 0;

        // Loop and Logic
        for (int i = 0; i < n; i++) {
            // Validation Check
            if (number[i] != 4 && number[i] != 7) {
                System.out.println("NO");
                x = 1;
                break;
            }

            // Sum Calculation
            if (i < n / 2) {
                h1 += number[i];
            } else {
                h2 += number[i];
            }
        }

        // Final Output
        if (x == 0) {
            if (h1 == h2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}