import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class codeforces_7_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read t and m
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] parts = line1.split(" ");
        if (parts.length < 2) return;

        int t = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        // Initialize alocuente (using int array)
        int[] alocuente = new int[m];
        // alocuente is initialized to 0 by default in Java for int arrays.

        int ind = 1;

        for (int i = 0; i < t; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            String[] op = line.split(" ");
            if (op.length == 0) continue;

            String command = op[0];

            if (command.equals("alloc")) {
                if (op.length < 2) continue;
                int size = Integer.parseInt(op[1]);
                
                int pos = 0;
                boolean allocated = false;

                for (int j = 0; j < m; j++) {
                    if (alocuente[j] == 0) {
                        pos++;
                        if (pos == size) {
                            // Allocate the block
                            // Python slice: alocuente [ j - int(op[1]) + 1 : j + 1 ] = [ ind ] * int(op[1])
                            // This logic seems to allocate space starting from index j - size + 1 up to j.
                            // Since we are looking for a contiguous block of 'size' zeros, we allocate it starting at the first zero found.
                            
                            // Find the start index of the block of 'size' zeros ending at j
                            int start = j - size + 1;
                            
                            // Allocate the block
                            for (int k = 0; k < size; k++) {
                                alocuente[start + k] = ind;
                            }
                            
                            System.out.println(ind);
                            ind++;
                            allocated = true;
                            break;
                        }
                    } else {
                        pos = 0;
                    }
                }

                if (!allocated) {
                    System.out.println("NULL");
                }

            } else if (command.equals("erase")) {
                if (op.length < 2) continue;
                int size = Integer.parseInt(op[1]);

                // Check if size is valid (Python check: if size not in alocuente or size == 0)
                boolean sizeExists = false;
                for (int val : alocuente) {
                    if (val == size) {
                        sizeExists = true;
                        break;
                    }
                }
                
                if (!sizeExists || size == 0) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                } else {
                    // Erase logic: set blocks of size 'size' to 0
                    for (int j = 0; j < m; j++) {
                        // Python check: if size > 0 and alocuente[j] == size
                        if (size > 0 && alocuente[j] == size) {
                            alocuente[j] = 0;
                        }
                    }
                }

            } else if (command.equals("defragment")) {
                // Defragmentation logic
                
                // 1. Count zeros
                int zeroCount = 0;
                for (int val : alocuente