import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

        // --- Input Reading based on Python structure ---

        // N, X = map(int, input().split())
        String line1 = br.readLine();
        if (line1 == null) return;
        String[] parts1 = line1.split(" ");
        if (parts1.length < 2) return;
        int N = Integer.parseInt(parts1[0]);
        // X is read but not used in the subsequent logic flow shown in the snippet. We skip reading it if it's not used later.
        
        // x = [0]*N (Placeholder, likely unused)
        String line2 = br.readLine();
        // x is read but not used in the subsequent logic flow shown in the snippet.

        // P and Y reading (N pairs of inputs)
        // P = [0]*N, Y = [0]*N
        int[][] P = new int[N][2];
        int[][] Y = new int[N][2];
        
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            if (line == null) break;
            String[] parts = line.split(" ");
            if (parts.length >= 2) {
                P[n][0] = Integer.parseInt(parts[0]);
                P[n][1] = Integer.parseInt(parts[1]);
                // Assuming the input structure implies P[n] and Y[n] are read sequentially, 
                // but the Python snippet only shows reading P[n], Y[n] in one line: P[n], Y[n] = map(int, input().split())
                // We assume the input provides N lines, each containing two integers for P and Y.
            }
        }
        
        // The line 'all(nstr.count(c) for c in '753')' is a check, skipped for direct translation.
