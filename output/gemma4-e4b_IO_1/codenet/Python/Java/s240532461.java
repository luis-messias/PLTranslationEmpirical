import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

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
        
        // Handle the case where N=0 (though constraints usually prevent this)
        if (aji.isEmpty()) {
            System.out.println(0);
            return;
        }

        // 1. Find min and max
        int minAji = aji.get(0);
        int maxAji = aji.get(0);
        for (int x : aji) {
            minAji = Math.min(minAji, x);
            maxAji = Math.max(maxAji, x);
        }
        
        int elementToRemove = 0;

        // 2. Determine element to remove based on conditions
        if (minAji >= 0) {
            // Case 1: min(aji) >= 0. Remove min.
            elementToRemove = minAji;
        } else if (maxAji <= 0) {
            // Case 2: max(aji) <= 0. Remove max.
            elementToRemove = maxAji;
        } else {
            // Case 3: Mixed signs. Remove element closest to zero (min absolute value).
            int minAbsValue = Integer.MAX_VALUE;
            elementToRemove = 0; 
            
            for (int x : aji) {
                int absValue = Math.abs(x);
                if (absValue < minAbsValue) {
                    minAbsValue = absValue;
                    elementToRemove = x;
                }
            }
        }
        
        // 3. Perform removal
        // Find the index of the element to remove (first occurrence)
        int indexToRemove = aji.indexOf(elementToRemove);
        if (indexToRemove != -1) {
            aji.remove(indexToRemove);
        }
        
        // 4. Calculate and print the sum
        long sum = 0;
        for (int x : aji) {
            sum += x;
        }
        System.out.println(sum);
    }
}
