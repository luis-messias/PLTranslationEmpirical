import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC149_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        if (parts.length < 3) {
            return;
        }
        
        int c0 = Integer.parseInt(parts[0]);
        int c1 = Integer.parseInt(parts[1]);
        int c2 = Integer.parseInt(parts[2]);
        
        // leftOver = cookies[0] - cookies[2]
        int leftOver = c0 - c2;
        
        // takahashi = max(0, leftOver)
        int takahashi = Math.max(0, leftOver);
        
        int secondValue;
        
        // Conditional expression: (str(cookies[1]) if takahashi > 0 else str(max(0, cookies[1] - abs(leftOver))))
        if (takahashi > 0) {
            secondValue = c1;
        } else {
            secondValue = Math.max(0, c1 - Math.abs(leftOver));
        }
        
        // Print (str(takahashi) + ' ' + secondValue)
        System.out.print(takahashi + " " + secondValue);
        
        // Note: If the requirement is strictly to replicate the Python print behavior which prints the result, 
        // the above System.out.print achieves the required output format.
    }
}
