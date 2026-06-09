import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class atcoder_ABC140_F {

    // Helper function to read a single integer N
    private static int readInt(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }

    // Helper function to read a line of space-separated integers
    private static ArrayList<Integer> readList(Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        try {
                            list.add(Integer.parseInt(part));
                        } catch (NumberFormatException e) {
                            // Ignore non-integer parts
                        }
                    }
                }
            }
        }
        return list;
    }

    public static String main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N
        int N = readInt(scanner);

        // 2. Read the list of available numbers (S)
        // Consume the rest of the line after reading N
        if (scanner.hasNextLine()) {
            scanner.nextLine(); 
        }
        
        ArrayList<Integer> S_list = readList(scanner);
        
        // 3. Sort S in descending order
        ArrayList<Integer> S = new ArrayList<>(S_list);
        S.sort(Collections.reverseOrder());

        int L = S.size();
        
        // 4. Initialize flag array (boolean usage tracking)
        boolean[] flag = new boolean[L];
        Arrays.fill(flag, true);

        // 5. Initialize current sequence (cur)
        ArrayList<Integer> cur = new ArrayList<>();
        
        if (L == 0) {
            return N == 0 ? "Yes" : "No";
        }

        // Initial step: cur starts with the largest element S[0]
        cur.add(S.get(0));
        flag[0] = false;

        // Main loop: N iterations
        for (int i = 0; i < N; i++) {
            int j = 0; // Index for the element in 'cur' we are comparing against
            int jM = cur.size(); // Current length of cur (number of elements needed)
            
            boolean foundAll = false;
            
            // Inner loop: Try to find jM new elements
            for (int k = 0; k < L; k++) {
                if (flag[k]) {
                    int s_k = S.get(k);
                    int cur_j = cur.get(j);
                    
                    // Condition: S[k] is unused AND S[k] < cur[j]
                    if (s_k < cur_j) {
                        // Found a suitable element
                        cur.add(s_k);
                        j++;
                        flag[k] = false;
                        
                        // Check if we have filled all required positions
                        if (j == jM) {
                            foundAll = true;
                            break; // Break inner loop, successful extension
                        }
                    }
                }
            }
            
            // Check if we failed to find enough elements (equivalent to Python's for...else)
            if (!foundAll) {
                return "No";
            }
            
            // Sort cur in descending order for the next iteration
            cur.sort(Collections.reverseOrder());
        }

        return "Yes";
    }
}
