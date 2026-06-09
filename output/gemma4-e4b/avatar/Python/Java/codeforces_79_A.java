import java.util.Scanner;

public class codeforces_79_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two integers from a single line of input
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or malformed
            return;
        }
        
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        // a acts as a boolean toggle (0 or 1)
        int a = 0; 

        // Loop condition: x >= 0 and y >= 22 OR x >= 1 and y >= 12 OR x >= 2 and y >= 2
        while ((x >= 0 && y >= 22) || (x >= 1 && y >= 12) || (x >= 2 && y >= 2)) {
            
            if (a == 1) {
                // Logic when a is True (1)
                if (y >= 22) {
                    y -= 22;
                } else if (x >= 1 && y >= 12) {
                    x -= 1;
                    y -= 12;
                } else {
                    x -= 2;
                    y -= 2;
                }
            } else {
                // Logic when a is False (0)
                if (x >= 2 && y >= 2) {
                    x -= 2;
                    y -= 2;
                } else if (x >= 1 && y >= 12) {
                    x -= 1;
                    y -= 12;
                } else {
                    y -= 22;
                }
            }
            
            // Toggle a: a = 1 - a
            a = 1 - a;
        }
        
        // Output: ['Ciel', 'Hanako'][1 - a]
        // If a=0, index is 1 -> "Hanako"
        // If a=1, index is 0 -> "Ciel"
        String[] results = {"Ciel", "Hanako"};
        System.out.println(results[1 - a]);
        
        scanner.close();
    }
}