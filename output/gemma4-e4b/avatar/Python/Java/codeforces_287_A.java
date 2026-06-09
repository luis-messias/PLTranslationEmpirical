import java.util.Scanner;

public class codeforces_287_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // t will store the grid. Assuming the input provides enough lines 
        // to support the loop structure (4 lines read, 3x3 grid implied by logic).
        // We read 4 lines as per the Python code structure.
        String[][] t = new String[4][];
        
        for (int i = 0; i < 4; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Assuming the input line consists of characters that form the row
                t[i] = line.split("");
            } else {
                // Handle case where input ends early
                t[i] = new String[0];
            }
        }
        
        scanner.close();

        int black = 0;
        int white = 0;
        int correct = 0;

        // The loops run up to 3, which might cause IndexOutOfBounds 
        // if the grid is only 3x3, but we translate the structure literally.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                // Check 2x2 area starting at (i, j)
                
                // Top-left: t[i][j]
                if (t[i][j].equals("#")) {
                    black++;
                } else {
                    white++;
                }
                
                // Top-right: t[i][j+1]
                if (j + 1 < t[i].length)