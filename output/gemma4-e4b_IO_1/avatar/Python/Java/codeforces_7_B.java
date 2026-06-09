import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class codeforces_7_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read t (number of operations) and m (memory size)
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        int m = scanner.nextInt();

        // Initialize memory array
        int[] alocuente = new int[m];
        
        // Next available ID
        int ind = 1;

        for (int i = 0; i < t; i++) {
            // Read the operation type and its argument (if present)
            String operation = scanner.next();
            String argStr = "";
            
            if (operation.equals("alloc") || operation.equals("erase")) {
                argStr = scanner.next();
            }
            
            int opArg = 0;
            if (!argStr.isEmpty()) {
                try {
                    opArg = Integer.parseInt(argStr);
                } catch (NumberFormatException e) {
                    // Should not happen based on problem constraints
                }
            }

            if (operation.equals("alloc")) {
                int requiredSize = opArg;
                int pos = 0;
                int startBlockIndex = -1;
                int endBlockIndex = -1;
                boolean allocated = false;

                for (int j = 0; j < m; j++) {
                    if (alocuente[j] == 0) {
                        if (pos == 0) {
                            startBlockIndex = j;
                        }
                        pos++;
                        
                        if (pos == requiredSize) {
                            endBlockIndex = j;
                            allocated = true;
                            break;
                        }
                    } else {
                        pos = 0;
                        startBlockIndex = -1;
                    }
                }

                if (allocated) {
                    // Allocate the block
                    for (int j = startBlockIndex; j <= endBlockIndex; j++) {
                        alocuente[j] = ind;
                    }
                    System.out.println(ind);
                    ind++;
                } else {
                    System.out.
