import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class s240532461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and L
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        
        ArrayList<Integer> aji = new ArrayList<>();
        
        // Populate aji: L, L+1, ..., L+N-1
        for (int i = 0; i < N; i++) {
            aji.add(L + i);
        }
        
        int elementToRemove = 0;
        boolean removed = false;

        // Case 1: min(aji) >= 0
        int minAji = aji.get(0);
        for (int x : aji) {
            if (x < minAji) {
                minAji = x;
            }
        }
        
        if (minAji >= 0) {
            elementToRemove = minAji;
            removed = true;
        } 
        // Case 2: max(aji) <= 0
        else {
            int maxAji = aji.get(0);
            for (int x : aji) {
                if (x > maxAji) {
                    maxAji = x;
                }
            }
            
            if (maxAji <= 0) {
                elementToRemove = maxAji;
                removed = true;
            } 
            // Case 3: else (mixed signs)
            else {
                // Find element closest to zero (min absolute value)
                int minAbsValue = Integer.MAX_VALUE;
                elementToRemove = 0; // Placeholder
                
                for (int x : aji) {
                    int absValue = Math.abs(x);
                    if (absValue < minAbsValue) {
                        minAbsValue = absValue;
                        elementToRemove = x;
                    }
                }
                removed = true;
            }
        }
        
        // Perform removal
        if (removed) {
            // Find the index of the element to remove
            int indexToRemove = aji.indexOf(elementToRemove);
            if (indexToRemove != -1) {
                aji.remove(indexToRemove);
            }
        }
        
        // Calculate and print the sum