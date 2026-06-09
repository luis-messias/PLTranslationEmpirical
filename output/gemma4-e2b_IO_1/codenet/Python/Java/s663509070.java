import java.util.Scanner;
import java.lang.Math;

public class s663509070 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and D
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        // D is read but unused in the distance calculation logic provided
        int D = scanner.nextInt(); 

        // Read the matrix
        int[][] mat = new int[N][];
        
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            // Handle potential issues if nextInt() was used previously and left a newline, 
            // or if we need to parse the line.
            
            // Since the Python code uses input().split(), we need to parse the line read.
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
                // Skip empty lines if any, or handle error if input format is strict
                i--; // Re-process this line if it was empty/malformed, though usually we just continue
                continue;
            }
            
            mat[i] = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                mat[i][j] = Integer.parseInt(parts[j]);
            }
        }

        // Calculate the number of pairs with integer distance
        int c = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // Calculate squared Euclidean distance
                long sumOfSquares = 0;
                for (int k = 0; k < mat[i].length; k++) {
                    long diff = (long)mat[i][k] - mat[j][k];
                    sumOfSquares += diff * diff;
                }
                
                // Calculate distance
                double dist = Math.sqrt(sumOfSquares);
                
                // Check if the distance is an integer (within a small tolerance for floating point comparison)
                // Since the Python code used int(dist) == dist, we check if dist is very close to an integer.
                if (Math.abs(dist - Math.round(dist)) < 1e-9) {
                    c++;
                }
            }
        }

        System.out.println(c);
        scanner.close();
    }
}
