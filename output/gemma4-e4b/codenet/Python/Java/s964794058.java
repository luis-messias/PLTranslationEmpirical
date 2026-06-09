import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class s964794058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read memTime
        if (!scanner.hasNextInt()) {
            return;
        }
        int memTime = scanner.nextInt();
        
        // Consume the rest of the line after memTime
        scanner.nextLine(); 

        // Read the entire line for memLate
        String line = scanner.nextLine();
        String[] tokens = line.split("\\s+");
        
        // Use a Set to store unique colors (equivalent to Python's colorList)
        Set<Integer> colorSet = new HashSet<>();
        int highLate = 0;

        // Iterate through the members, up to memTime or the number of tokens available
        int limit = Math.min(memTime, tokens.length);

        for (int i = 0; i < limit; i++) {
            try {
                int member = Integer.parseInt(tokens[i]);
                // Integer division in Java
                int color = member / 400; 
                
                if (color >= 8) {
                    highLate++;
                } else {
                    // Add to the set. Set.add() returns true if the element was added (i.e., it was unique).
                    colorSet.add(color);
                }
            } catch (NumberFormatException e) {
                // Skip if token is not a valid integer
            }
        }
        
        // Calculate results
        int lenColorList = colorSet.size();
        int maxColor =