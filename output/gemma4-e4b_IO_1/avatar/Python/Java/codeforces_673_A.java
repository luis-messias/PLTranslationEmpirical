import java.util.Scanner;
import java.util.Arrays;

public class codeforces_673_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (although n is unused in the logic, it must be consumed)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading n
        scanner.nextLine();

        // Read the line containing space-separated array elements
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        // Handle empty input line
        if (line.trim().isEmpty()) {
            return;
        }

        // Parse the line into an array of integers
        String[] tokens = line.trim().split("\\s+");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        // Python logic translation
        if (arr[0] > 15) {
            System.out.println(15);
        } else {
            boolean breakOccurred = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] > 15) {
                    System.out.println(arr[i - 1] + 15);
                    breakOccurred = true;
                    break;
                }
            }
            
            // This block executes if the loop completed without hitting 'break' (Python for/else)
            if (!breakOccurred) {
                int lastElement = arr[arr.length - 1];
                if (lastElement == 90 || lastElement + 15 >= 90) {
                    System.out.println(90);
                } else {
                    System.out.println(lastElement + 15);
                }
            }
        }
        
        scanner.close();
    }
}
