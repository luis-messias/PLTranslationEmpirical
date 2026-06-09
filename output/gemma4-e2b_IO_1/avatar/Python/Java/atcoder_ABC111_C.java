import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC111_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the sequence x
        List<Integer> xList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                xList.add(scanner.nextInt());
            } else {
                // Handle case where input might end prematurely
                break;
            }
        }
        
        // Split xList into a and b based on index parity
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a.add(xList.get(i));
            } else {
                b.add(xList.get(i));
            }
        }

        // Determine the maximum possible value for array sizing. 
        // Since the Python code initializes arrays up to 100002, we use that size.
        final int MAX_VAL = 100002;
        int[] cnta = new int[MAX_VAL + 1];
        int[] cntb = new int[MAX_VAL + 1];

        // Calculate frequencies for A
        for (int val : a) {
            if (val <= MAX_VAL) {
                cnta[val]++;
            }
        }

        // Calculate frequencies for B
        for (int val : b) {
            if (val <= MAX_VAL) {
                cntb[val]++;
            }
        }

        // --- Find mode and second mode for A ---
        int vala = 0;
        int maxCnta = 0;
        int vala1 = 0;
        int maxCnta1 = 0;

        // Find the mode (vala)
        for (int val : a) {
            if (cnta[val] > maxCnta) {
                vala = val;
                maxCnta = cnta[val];
            }
        }

        // Find the second mode (vala1)
        for (int val : a) {
            if (cnta[val] > maxCnta1 && val != vala) {
                maxCnta1 = cnta[val];
                vala1 = val;
            }
        }

        // --- Find mode and second mode for B ---
        int valb = 0;
        int maxCntb = 0;
        int valb1 = 0;
        int maxCntb1 = 0;

        // Find the mode (valb)
        for (int val : b) {
            if (cntb[val] > maxCntb) {
                valb = val;
                maxCntb = cntb[val];
            }
        }

        // Find the second mode (valb1)
        for (int val : b) {
            if (cntb[val] > maxCntb1 && val != valb) {
                maxCntb
