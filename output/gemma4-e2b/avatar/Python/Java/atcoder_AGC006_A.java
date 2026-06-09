import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_AGC006_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read s (assuming space-separated integers on the next line)
        List<Integer> s = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String lineS = scanner.nextLine();
            String[] partsS = lineS.trim().split("\\s+");
            for (String part : partsS) {
                if (!part.isEmpty()) {
                    s.add(Integer.parseInt(part));
                }
            }
        }

        // Read t
        List<Integer> t = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String lineT = scanner.nextLine();
            String[] partsT = lineT.trim().split("\\s+");
            for (String part : partsT) {
                if (!part.isEmpty()) {
                    t.add(Integer.parseInt(part));
                }
            }
        }

        // Check if s == t
        if (s.equals(t)) {
            System.out.println(n);
        } else {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    // Python indexing: s[i + j] and t[j]
                    // Note: In Java List access, we use .get(index)
                    // The Python code implies s and t are indexed by i+j and j respectively.
                    // Since s and t are lists of length n, indices must be checked against bounds.
                    
                    // Python: if s[i + j] != t[j]:
                    // The Python code uses s[i+j]. If i=0, j=n-1, s[n-1] vs t[n-1].
                    // If i=n-1, j=0, s[n-1] vs t[0].
                    
                    // We must ensure i+j < n for s[i+j] and j < n for t[j].
                    // Since j < n-i, i+j < n. So s[i+j] is safe.
                    
                    if (!s.get(i + j).equals(t.get(j))) {
                        break;
                    }
                    
                    // Python: if j == n - i - 1:
                    if (j == n - i - 1) {
                        cnt = n - i;
                    }
                }
            }
            System.out.println(2 * n - cnt);
        }
        
        scanner.close();
    }
}