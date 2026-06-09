import java.util.Scanner;
import java.util.Arrays;

public class s747093551 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, M, X, Y from the first line
        // Note: The Python code reads these four values, but only X and Y are used in the final comparison logic, along with the lists x and y.
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int M = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int X = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int Y = scanner.nextInt();

        // Read list x
        // Assuming x is on the second line
        if (!scanner.hasNextLine()) return;
        String lineX = scanner.nextLine();
        String[] xTokens = lineX.trim().split("\\s+");
        int[] x = new int[xTokens.length];
        for (int i = 0; i < xTokens.length; i++) {
            x[i] = Integer.parseInt(xTokens[i]);
        }

        // Read list y
        // Assuming y is on the third line
        if (!scanner.hasNextLine()) return;
        String lineY = scanner.nextLine();
        String[] yTokens = lineY.trim().split("\\s+");
        int[] y = new int[yTokens.length];
        for (int i = 0; i < yTokens.length; i++) {
            y[i] = Integer.parseInt(yTokens[i]);
        }

        // Calculate max(x) and min(y)
        int maxX = Integer.MAX_VALUE;
        if (x.length > 0) {
            for (int val : x) {
                if (val > maxX) {
                    maxX = val;
                }
            }
        } else {
            // Handle case where x is empty, though unlikely based on problem context
            maxX = Integer.MIN_VALUE; 
        }

        int minY = Integer.MAX_VALUE;
        if (y.length > 0) {
            for (int val : y) {
                if (val < minY) {
                    minY = val;
                }
            }
        } else {
            // Handle case where y is empty
            minY = Integer.MAX_VALUE;
        }
        
        // The Python logic: 'No War' if max(max(x),X) < min(min(y),Y) else 'War'
        // max(max(x), X)
        int leftSide = Math.max(maxX, X);
        
        // min(min(y), Y)
        int rightSide = Math.min(minY, Y);

        if (leftSide < rightSide) {
            System.out.println("No War");
        } else {
            System.out.println("War");
        }
        
        scanner.close();
    }
}