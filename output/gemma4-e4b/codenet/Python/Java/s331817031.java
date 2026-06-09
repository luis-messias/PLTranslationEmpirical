import java.util.Scanner;

public class s331817031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int h = scanner.nextInt();
        int w = scanner.nextInt();
        
        // Consume the rest of the line after reading w
        scanner.nextLine(); 

        char[][] grid = new char[h][w];
        
        // Read the grid row by row
        for (int i = 0; i < h; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                // Assuming the input line length matches w
                if (j < line.length()) {
                    grid[i][j] = line.charAt(j);
                } else {
                    // Should not happen if input adheres to w
                    grid[i][j] = ' '; 
                }
            }
        }
        
        int tmp = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '#') {
                    if (j < tmp) {
                        System.out.println("Impossible");
                        return;
                    } else {
                        tmp = j;
                    }
                }
            }
        }

        System.out.println("Possible");
    }
}