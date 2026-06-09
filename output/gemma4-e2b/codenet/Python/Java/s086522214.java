import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class s086522214 {

    // 素因数を並べる (Prime Decomposition)
    public static List<Integer> primeDecomposition(int n) {
        List<Integer> table = new ArrayList<>();
        int i = 2;
        int tempN = n;
        while (i * i <= tempN) {
            while (tempN % i == 0) {
                tempN /= i;
                table.add(i);
            }
            i++;
        }
        if (tempN > 1) {
            table.add(tempN);
        }
        return table;
    }

    // 桁数を吐く (Digit extraction - Note: This Python function returns a list, which is complex to replicate directly in a simple Java context without stream/string manipulation)
    // Since the usage in the main flow is unclear, we omit a direct translation unless context is provided.

    // getNearestValueIndex (Finding nearest value index)
    public static int getNearestValueIndex(List<Integer> list, int num) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        
        int minDiff = Integer.MAX_VALUE;
        int nearestIndex = -1;

        for (int i = 0; i < list.size(); i++) {
            int diff = Math.abs(list.get(i) - num);
            if (diff < minDiff) {
                minDiff = diff;
                nearestIndex = i;
            }
        }
        return nearestIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading N, X
        String line1 = br.readLine();
        if (line1 == null) return;
        String[] parts1 = line1.split(" ");
        if (parts1.length < 2) return;
        int N = Integer.parseInt(parts1[0]);
        // X is read but not used in the subsequent logic flow shown in the snippet
        // int[] X = new int[N]; 
        
        // Reading X (assuming it's read here, though the snippet implies it might be skipped or contextually defined later)
        String line2 = br.readLine();
        // int[] x = new int[N];
        // String[] xParts = line2.split(" ");
        // for (int i = 0; i < N; i++) {
        //     x[i] = Integer.parseInt(xParts[i]);
        // }


        // Reading P and Y
        int[][] P = new int[N][2];
        int[][] Y = new int[N][2];
        
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            if (parts.length >= 2) {
                P[n][0] = Integer.parseInt(parts[0]);
                P[n][1] = Integer.parseInt(parts[1]);
                // Y[n][0] = Integer.parseInt(parts[2]); // Assuming P and Y are read sequentially
                // Y[n][1] = Integer.parseInt(parts[3]);
            }
        }
        
        // The line 'all(nstr.count(c) for c in '753')' is a check, likely related to input validation or constraints.
        // We skip this check as the context is missing.

        // 複数配列を並び替え (Sorting)
        // The Python code uses zip(A, B, totAB) which implies A, B, totAB were defined earlier.
        // Since A, B, totAB are not explicitly defined based on the input reading above, we must assume they are derived from P and Y, or that the input reading structure was different.
        
        // Placeholder for A, B, totAB based on P and Y structure (assuming P and Y are the arrays being sorted)
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> totAB = new ArrayList<>();
        
        for (int n = 0; n < N