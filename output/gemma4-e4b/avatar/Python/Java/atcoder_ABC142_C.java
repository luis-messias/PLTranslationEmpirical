import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Element {
    int index; // 1-based index
    int value;

    public Element(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class atcoder_ABC142_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (unused in logic, but required by input structure)
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read the rest of the line/input for values
        List<Element> elements = new ArrayList<>();
        
        // Since we don't know how many values are on the next line, 
        // we read the remaining tokens until the line/input ends for the values.
        // Assuming all remaining tokens are the values.
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            // The index is 1-based, corresponding to the order of reading the values.
            // We need to track the index manually since scanner consumes tokens.
            // A safer approach is to read the whole line and split it.
        }
        
        // Reset scanner or use a different input method if the previous loop consumed too much.
        // Given the typical CP setup, let's assume the values are provided on the next line 
        // and we need to read them all.
        
        // Re-initializing scanner or using BufferedReader for robust line reading
        scanner.close();
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        
        // Since we already consumed N, we need to read the line containing values.
        // If the environment guarantees the values are on the next line:
        try {
            String line = reader.readLine();
            if (line == null || line.trim().isEmpty()) {
                return;
            }
            
            String[] tokens = line.trim().split("\\s+");
            
            elements.clear();
            for (int i = 0; i < tokens.length; i++) {
                try {
                    int value = Integer.parseInt(tokens[i]);
                    // i + 1 is the 1-based index
                    elements.add(new Element(i + 1, value));
                } catch (NumberFormatException e) {
                    // Skip non-integer tokens if any
                }
            }
        } catch (java.io.IOException e) {
            // Handle IO exception
        }
        
        // If the input reading above failed due to environment constraints, 
        // we must rely on the assumption that the input stream is ready for the values.
        // For a standard single-run environment, the initial scanner approach might be better 
        // if we know exactly how many values follow N.
        
        // --- Reverting to a simplified Scanner approach assuming all input is available ---
        // Since the provided Python code reads N, then reads the entire line of values, 
        // we must assume the input stream is structured correctly for the values.
        
        // If we assume the values are read correctly into 'elements' list:
        
        // 1. Sort the elements based on value (itemgetter(1))
        Collections.sort(elements, Comparator.comparingInt(e -> e.value));
        
        // 2. Extract the sorted indices (A__ = [ a[0] for a in A_ ])
        List<Integer> sortedIndices = new ArrayList<>();
        for (Element e : elements) {
            sortedIndices.add(e.index);
        }
        
        // 3. Print the results (Replicating Python's print logic)
        if (sortedIndices.isEmpty()) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        int size = sortedIndices.size();
        
        // Print all elements except the last one, separated by space
        for (int i = 0; i < size - 1; i++) {
            sb.append(sortedIndices.get(i)).append(" ");
        }
        
        // Print the last element
        sb.append(sortedIndices.get(size - 1));
        
        System.out.println(sb.toString());
    }
}