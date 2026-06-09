import java.util.Arrays;
import java.util.Scanner;

public class codeforces_108_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            return;
        }
        
        String line = scanner.nextLine();
        
        // Split the input string by whitespace to get the numbers
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length < 2) {
            System.out.println("NO");
            return;
        }

        // Convert string parts to integers
        Integer[] a = new Integer[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            // Handle parsing error if necessary, though typically assumed valid in CP context
            return;
        }
        
        // Sort the array
        Arrays.sort(a);
        
        // Check the condition: a[i] != a[i - 1] and a[i] < a[i - 1] * 2
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1] && a[i] < a[i - 1] * 2) {
                System.out.println("YES");
                return;
            }
        }
        
        System.out.println("NO");
    }
}
