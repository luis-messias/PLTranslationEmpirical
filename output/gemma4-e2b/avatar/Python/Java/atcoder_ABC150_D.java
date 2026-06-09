import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

public class atcoder_ABC150_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and num from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int num = scanner.nextInt();

        // Read num_set from the second line
        if (!scanner.hasNextLine()) return;
        String line = scanner.nextLine();
        String[] numSetTokens = line.split(" ");
        
        Set<Integer> numSet = new HashSet<>();
        for (String token : numSetTokens) {
            if (!token.isEmpty()) {
                numSet.add(Integer.parseInt(token));
            }
        }

        Set<Integer> twoTimesSet = new HashSet<>();
        boolean conditionMet = true;

        for (int i : numSet) {
            // We need to handle the modification of i within the loop context.
            // Since i is read from the set, we must use a temporary variable if we want to preserve the original set elements, 
            // but the Python code modifies i directly. In Java, we use a temporary variable for the loop variable if we iterate over a copy, 
            // or if we iterate over the set elements, we must ensure the modification doesn't affect the set structure itself (which it doesn't, as we are iterating over the set elements).
            
            // Since the Python code modifies i inside the loop, we must use a mutable variable for the iteration.
            int currentI = i;
            
            for (int j = 1; j <= 29; j++) {
                currentI /= 2; // i //= 2
                if (currentI % 2 != 0) {
                    twoTimesSet.add(j);
                    break;
                }
            }

            if (twoTimesSet.size() != 1) {
                System.out.println(0);
                conditionMet = false;
                break;
            }
        }

        if (conditionMet) {
            List<Integer> numList = new ArrayList<>(numSet);
            
            // Calculate LCM
            if (numList.isEmpty()) {
                // Handle case where num_set is empty, although context implies it won't be.
                // If num_set is empty, the LCM calculation is undefined or context-dependent.
                // Assuming based on Python structure, if the loop finishes successfully, num_set is non-empty.
                return; 
            }
            
            long lcm = numList.get(0);
            
            for (int i = 1; i < num