import java.util.Scanner;
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
            String operation = scanner.next();
            String argStr = scanner.next();
            
            int opType = 0;
            int opArg = 0;

            if (operation.equals("alloc")) {
                opArg = Integer.parseInt(argStr);
            } else if (operation.equals("erase")) {
                opArg = Integer.parseInt(argStr);
            } else if (operation.equals("defragment")) {
                // No argument needed for defragment
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
                    System.out.println("NULL");
                }
            } 
            else if (operation.equals("erase")) {
                // Check if the argument is valid for erasure
                boolean found = false;
                for (int j = 0; j < m; j++) {
                    if (alocuente[j] == opArg) {
                        found = true;
                        break;
                    }
                }

                if (opArg <= 0 || !found) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                } else {
                    // Erase all occurrences
                    for (int j = 0; j < m; j++) {
                        if (alocuente[j]