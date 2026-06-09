import java.util.Scanner;
import java.lang.Math;

public class codeforces_459_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the entire line of input
        if (!scanner.hasNextLine()) {
            return;
        }
        String given = scanner.nextLine();
        
        // Split the input
        String[] l1 = given.split(" ");
        
        if (l1.length < 4) {
            return; // Not enough input
        }

        // Parse integers
        int x1 = Integer.parseInt(l1[0]);
        int y1 = Integer.parseInt(l1[1]);
        int x2 = Integer.parseInt(l1[2]);
        int y2 = Integer.parseInt(l1[3]);

        // Calculations
        int denominator = x2 - x1;
        int numerator = y2 - y1;

        if (denominator != 0) {
            double quotient = (double) numerator / denominator;
            
            if (numerator == 0) {
                // Case 1: numerator == 0
                double diffX = x2 - x1;
                double diffY = y2 - y1;
                double d = (int) Math.sqrt(diffX * diffX + diffY * diffY);
                
                int x4 = x1;
                int x3 = x2;
                int y3 = y2 + (int) d;
                int y4 = y1 + (int) d;
                
                System.out.println(x3 + " " + y3 + " " + x4 + " " + y4);
            }
        } else { // denominator == 0
            // Case 2: denominator == 0
            double diffX = x2 - x1;
            double diffY = y2 - y1;
            double d = (int) Math.sqrt(diffX * diffX + diffY * diffY);
            
            int y4 = y2;
            int y3 = y1;
            int x4 = x1 + (int) d;
            int x3 = x2 + (int) d;
            
            System.out.println(x3 + " " + y3 + " " + x4 + " " + y4);
        }

        // Note: The Python code structure implies that if denominator != 0, 
        // the subsequent checks (quotient == 1 or