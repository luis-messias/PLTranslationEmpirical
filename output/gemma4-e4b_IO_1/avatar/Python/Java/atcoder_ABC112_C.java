import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class atcoder_ABC112_C {

    /**
     * Solves the problem by finding the unique candidate point (xx, yy, hh).
     * @param n The number of constraints.
     * @param ls_xyh The list of constraints [x, y, h].
     * @return The result string "xx yy hh".
     */
    public static String solve(int n, List<int[]> ls_xyh) {
        // 1. Find the base point (x0, y0, h0)
        int x0 = -1, y0 = -1, h0 = -1;
        boolean foundBase = false;
        for (int[] constraint : ls_xyh) {
            if (constraint[2] > 0) {
                x0 = constraint[0];
                y0 = constraint[1];
                h0 = constraint[2];
                foundBase = true;
                break;
            }
        }

        if (!foundBase) {
            // Should not happen based on problem constraints
            return "0 0 0"; 
        }

        // 2. Initialize candidates list (cands)
        // Each candidate is stored as int[cx, cy, ch]
        List<int[]> cands = new ArrayList<>();
        for (int cx = 0; cx <= 100; cx++) {
            for (int cy = 0; cy <= 100; cy++) {
                // ch = h0 + |cx - x0| + |cy - y0|
                int ch = h0 + Math.abs(cx - x0) + Math.abs(cy - y0);
                cands.add(new int[]{cx, cy, ch});
            }
        }

        // 3. Filter candidates based on all constraints
        for (int[] constraint : ls_xyh) {
            int x = constraint[0];
            int y = constraint[1];
            int h = constraint[2];

            List<int[]> nextCands = new ArrayList<>();
            
            for (int[] cand : cands) {
                int cx = cand[0];
                int cy = cand[1];
                int ch = cand[2];

                // Calculate max(ch - |cx - x| - |cy - y|, 0)
                int reduction = Math.abs(cx - x) + Math.abs(cy - y);
                int calculatedH = Math.max(ch - reduction, 0);

                // Check if the condition holds: calculatedH == h
                if (calculatedH == h) {
                    nextCands.add(cand);
                }
            }
            cands = nextCands;
        }

        // 4. Return the result (the first candidate remaining)
        if (cands.isEmpty()) {
            return "0 0 0";
        }

        int[] result = cands.get(0);
        return result[0] + " " + result[1] + " " + result[2];
    }

    /**
     * Reads the input structure (N and the list of constraints).
     * @param scanner The Scanner object reading from standard input.
     * @return An InputData object containing N and the list of constraints.
     */
    public static InputData readQuestion(Scanner scanner) {
        // Read N
        if (!scanner.hasNextInt()) {
            return new InputData(0, new ArrayList<>());
        }
        int n = scanner.nextInt();
        
        // Read N constraints
        List<int[]> ls_xyh = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input ends prematurely
                break;
            }
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int h = scanner.nextInt();
            ls_xyh.add(new int[]{x, y, h});
        }
        
        return new InputData(n, ls_xyh);
    }

    // Helper class to hold the read input data
    static class InputData {
        int n;
        List<int[]> ls_xyh;

        public InputData(int n, List<int[]> ls_xyh) {
            this.n = n;
            this.ls_xyh = ls_xyh;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        InputData data = readQuestion(scanner);
        
        // Call solve using the data read
        String result = solve(data.n, data.ls_xyh);
        
        System.out.println(result);
        
        scanner.close();
    }
}
