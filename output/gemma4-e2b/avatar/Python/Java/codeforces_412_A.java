import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class codeforces_412_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int k = scanner.nextInt();

        // Read v
        if (!scanner.hasNext()) return;
        String v = scanner.next();

        // d = [ "LEFT" , "RIGHT" ]
        String[] d = { "LEFT", "RIGHT" };

        // f = k - 1 < n - k
        boolean f = (k - 1 < n - k);

        // m = min ( k - 1 , n - k )
        int m = Math.min(k - 1, n - k);

        // a = [ ]
        List<String> a = new ArrayList<>();

        // First loop: for i in range ( 0 , m ) : a.append ( d [ not f ] )
        for (int i = 0; i < m; i++) {
            a.add(d[(!f ? 1 : 0)]); // d[not f] is equivalent to d[1-f] if f is 0 or 1, or d[1-f] if f is 0 or 1.
                                  // In Python, `not f` evaluates to True (1) or False (0).
                                  // If f is False (0), not f is True (1). d[1] = "RIGHT".
                                  // If f is True (1), not f is False (0). d[0] = "LEFT".
                                  // This is equivalent to d[1 - f].
            a.add(d[1 - (f ? 1 : 0)]); // Simplified logic for d[not f]
        }
        
        // Re-evaluating d[not f]:
        // If f is False (0), not f is True (1). d[1] = "RIGHT".
        // If f is True (1), not f is False (0). d[0] = "LEFT".
        // This is exactly d[1 - f].
        
        // Let's stick to the direct translation of the Python logic for clarity, although the Python expression `d[not f]` is slightly tricky if `d` is indexed by 0 and 1.
        // Since d has only two elements, d[not f] means: if f is true, use d[0]; if f is false, use d[1].
        // If f is True (1), not f is 0. d[0] = "LEFT".
        // If f is False (0), not f is 1. d[1] = "RIGHT".
        // This is d[1 - f].

        // Let's use the calculated value directly:
        for (int i = 0; i < m; i++) {
            if (!f) {
                a.add(d[1]); // If f is False, append RIGHT
            } else {
                a.add(d[0]); // If f is True, append LEFT
            }
        }


        // Second loop: for i in v [ : : - 1 + 2 * f ] :
        int start = v.length() - 1 + 2 * (f ? 1 : 0);
        
        for (int i = start; i < v.length(); i += 1) {
            a.add("PRINT " + i);
            a.add(d[1 - (f ? 1 : 0)]); // d[f]
        }

        // print ( * a [ : - 1 ] , sep = "\n" )
        // Print all elements of a except the last one, separated by newlines.
        for (int i = 0; i < a.size() - 1; i++) {
            System.out.println(a.get(i));
        }
    }
}