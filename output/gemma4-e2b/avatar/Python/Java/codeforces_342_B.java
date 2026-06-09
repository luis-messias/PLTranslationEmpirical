import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_342_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // R function equivalent: reads a line and returns space-separated integers
        // Since we are reading from standard input, we will read line by line.

        // Read n, m, s, f from the first line
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        if (parts1.length < 4) return;
        
        int n = Integer.parseInt(parts1[0]);
        int m = Integer.parseInt(parts1[1]);
        int s = Integer.parseInt(parts1[2]);
        int f = Integer.parseInt(parts1[3]);

        // Determine direction d and character c
        int d;
        char c;
        if (s < f) {
            d = 1;
            c = 'R';
        } else {
            d = -1;
            c = 'L';
        }

        StringBuilder res = new StringBuilder();
        int i = 1;
        int j = s;

        // Read the m boundary sets (t, l, r)
        List<int[]> boundaries = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            if (parts.length >= 3) {
                int t = Integer.parseInt(parts[0]);
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                boundaries.add(new int[]{t, l, r});
            }
        }

        // t, l, r = R() equivalent for the first set
        if (boundaries.isEmpty()) {
            // Handle case where input might be incomplete, though based on Python structure, 
            // we assume m boundary sets follow.
            return;
        }
        
        int t = boundaries.get(0)[0];
        int l = boundaries.get(0)[1];
        int r = boundaries.get(0)[2];
        int k = 1; // k tracks which boundary set we are currently using (1-indexed)

        // Main loop
        while (j != f) {
            // Check if we need to read the next boundary set
            if (i > t && k < m) {
                int[] nextBoundary = boundaries.get(k);
                t = nextBoundary[0];
                l = nextBoundary[1];
                r = nextBoundary[2];
                k += 1;
            }

            // Check for 'X' condition
            if (i == t && (j >= l && j <= r || j + d >= l && j + d <= r)) {
                res.append('X');
            } else {
                res.append(c);
                j += d;
            }
            i += 1;
        }

        System.out.println(res.toString());
        scanner.close();
    }
}