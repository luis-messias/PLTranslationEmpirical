import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class atcoder_AGC033_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read h and w
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or malformed
            return;
        }
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        
        // Consume the rest of the line after reading w
        scanner.nextLine(); 

        // Initialize the graph array
        double[][] graph = new double[h][w];

        // Read the graph data
        for (int i = 0; i < h; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    graph[i][j] = 0.0;
                } else {
                    // Assuming non-'#' characters are intended to be treated as infinity initially, 
                    // following the literal Python translation: float('inf')