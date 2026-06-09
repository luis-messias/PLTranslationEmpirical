import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class atcoder_AGC006_B {

    // Helper function equivalent to Python's sub
    private static List<Integer> sub(List<Integer> y, boolean debug) {
        if (debug) {
            System.out.println("D " + y);
        }
        
        List<Integer> newY = new ArrayList<>();
        int limit = y.size() - 2;
        
        // The Python logic iterates for i in range(len(y) - 2)
        for (int i = 0; i < limit; i++) {
            // Extract the triplet y[i:i+3]
            // We need to handle subList carefully, as it returns a view.
            List<Integer> triplet = y.subList(i, i + 3);
            
            // Sort the triplet and take the middle element (index 1)
            List<Integer> sortedTriplet = new ArrayList<>(triplet);
            Collections.sort(sortedTriplet);
            newY.add(sortedTriplet.get(1));
        }
        
        if (debug) {
            System.out.println("D " + newY);
        }
        return newY;
    }

    // Equivalent to Python's calc (though the main logic flow handles the return value directly)
    // We will integrate the logic directly into main for simplicity based on the Python structure.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and X
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int X = scanner.nextInt();
        
        // The Python code uses itertools.permutations, but the provided logic doesn't seem to use it directly.
        // We follow the structure derived from the provided logic.

        // The Python code defines a function 'calc(x)' which returns a value, 
        // but the main flow seems to execute the logic directly based on the result of sub(x).
        
        // Let's replicate the flow:
        
        // 1. y = sub(x)
        List<Integer> y = sub(Arrays.asList(X)); // Assuming x is passed as a list of size 1 if we follow the structure, but the Python implies x is an integer input.
        
        // Re-evaluating the Python input: N, X = input().split() implies X is the variable being tested.
        // The function calc(x) is called, and the result is returned.
        // The main block uses X and N directly.
        
        // Since the Python code structure is highly procedural and relies on global state/input, 
        // we must assume the input reading is the start of the execution.
        
        // The Python code structure:
        /*
        y = sub(x)  <-- x is the input to calc
        if y[0] == 2:
            sub(x, 1)
            print("=" , x)
        return y[0]
        if X == 1 or X == N * 2 - 1: ...
        */
        
        // Since the provided context is a translation request, and the provided Java attempt failed mid-function call, 
        // I must assume the intent is to translate the entire logic flow based on the input N and X read from stdin.
        
        // We need to define the logic flow based on the input N and X read above.
        
        // Since the original Python code structure is confusingly mixed (input reading vs function definition vs main execution), 
        // I will focus on translating the final conditional logic based on N and X, as that seems to be the primary output mechanism.
        
        // If we strictly follow the Python structure where N and X are read first:
        
        // We need to define a way to handle the function calls and return values.
        
        // Let's assume the intent is to calculate the final output based on the input N and X read.
        
        // Since the provided Python code is self-contained and seems to be a single script execution, 
        // I will define the logic flow directly in main, using the helper function logic.
