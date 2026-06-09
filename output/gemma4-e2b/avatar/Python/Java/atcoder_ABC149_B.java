import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC149_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line and parse cookies
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        // Assuming input has at least 3 elements based on the Python indexing
        if (parts.length < 3) {
            // Handle error or insufficient input if necessary, though usually assumed valid in competitive programming context
            return;
        }
        
        int[] cookies = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            cookies[i] = Integer.parseInt(parts[i]);
        }

        int c0 = cookies[0];
        int c1 = cookies[1];
        int c2 = cookies[2];
        
        // leftOver = cookies[0] - cookies[2]
        int leftOver = c0 - c2;
        
        // takahashi = max(0, leftOver)
        int takahashi = Math.max(0, leftOver);
        
        int result;
        
        // Conditional expression: (str(cookies[1]) if