import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class atcoder_ABC150_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and num
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int num = scanner.nextInt();

        // Read num_set
        if (!scanner.hasNextLine()) return;
        String line = scanner.nextLine();
        String[] numSetTokens = line.split(" ");
        
        Set<Integer> numSet = new HashSet<>();
        for (String token : numSetTokens) {
            if (!token.isEmpty()) {
                try {
                    numSet.add(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    // Handle potential parsing errors if input is malformed
                }
            }
        }

        Set<Integer> twoTimesSet = new HashSet<>();
        boolean conditionMet = true;

        for (int i : numSet) {
            int currentI = i;
            
            // The Python loop iterates j from 1 to 29 (range(1, 30))
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
            
            if (numList.isEmpty()) {
                // If num_set is empty, we cannot proceed with LCM calculation based on the Python structure.
                // Assuming this case won't occur if the previous checks passed.
                return; 
            }
            
            // Calculate LCM using long to prevent overflow during intermediate steps
            long lcm = num
