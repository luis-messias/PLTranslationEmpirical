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
        
        List<Integer> result = new ArrayList<>();
        
        // The Python code iterates up to len(y) - 2
        for (int i = 0; i <= y.size() - 3; i++) {
            // Extract the triplet y[i:i+3]
            List<Integer> triplet = y.subList(i, i + 3);
            Collections.sort(triplet);
            result.add(triplet.get(1)); // Take the middle element (index 1)
        }
        
        // Note: The Python implementation seems to implicitly handle the list slicing/comprehension 
        // which results in a list of length len(y) - 2.
        // Let's re-examine the Python list comprehension:
        // y = [ sorted ( y [ i : i + 3 ] ) [ 1 ] for i in range ( len ( y ) - 2 ) ]
        // If len(y)=5, range(3). i=0, 1, 2. Result length is 3.
        
        // Reimplementing based strictly on the Python logic structure:
        List<Integer> newY = new ArrayList<>();
        int limit = y.size() - 2;
        for (int i = 0; i < limit; i++) {
            List<Integer> triplet = y.subList(i, i + 3);
            // Sort the triplet and take the middle element
            List<Integer> sortedTriplet = new ArrayList<>(triplet);
            Collections.sort(sortedTriplet);
            newY.add(sortedTriplet.get(1));
        }
        
        if (debug) {
            System.out.println("D " + newY);
        }
        return newY;
    }

    // Equivalent to Python's calc
    private static int calc(int x) {
        // Initial call: y = sub(x)
        List<Integer> y = sub(