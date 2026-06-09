import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC149_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the entire line of input
        String line = scanner.nextLine();
        
        // Split the line by spaces and parse into an array of longs
        String[] parts = line.split(" ");
        long[] cookies = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            cookies[i] = Long.parseLong(parts[i]);
        }
        
        // Calculate leftOver
        long leftOver = cookies[0] - cookies[2];
        
        // Calculate takahashi = max(0, leftOver)
        long takahashi = Math.max(0L, leftOver);
        
        long secondValue;
        
        // Conditional logic for the second value
        if (takahashi > 0) {
            // If takahashi > 0, the second value is cookies[1]
            secondValue = cookies[1];
        } else {
            // If takahashi <= 0, the second value is max(0, cookies[1] - abs(leftOver))
            long absoluteLeftOver = Math.abs(leftOver);
            secondValue = Math.max(0L, cookies[1] - absoluteLeftOver);
        }
        
        // Print the result
        System.out.println(takahashi + " " + secondValue);
    }
}
