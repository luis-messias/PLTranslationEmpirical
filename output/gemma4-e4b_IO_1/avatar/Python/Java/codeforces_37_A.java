import java.util.Arrays;
import java.util.Scanner;

public class codeforces_37_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the list l (n elements)
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                l[i] = scanner.nextInt();
            } else {
                // Handle case where input ends prematurely
                break;
            }
        }
        
        if (n == 0) {
            System.out.println("1 0");
            return;
        }

        // Initialization
        int high = 1;
        int tower = n;
        int maximum = 1;

        // Sort l
        Arrays.sort(l);

        // Loop through the sorted array
        for (int i = 1; i < n; i++) {
            if (l[i] == l[i - 1]) {
                tower -= 1;
                high += 1;
            } else {
                if (high > maximum) {
                    maximum = high;
                }
                high = 1;
            }
        }

        // Check the last sequence
        if (high > maximum) {
            maximum = high;
        }

        // Print the result
        System.out.println(maximum + " " + tower);
    }
}
