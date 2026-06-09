import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class atcoder_ABC169_E {
    public static void resolve() {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();

        // Read n pairs of inputs
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int b = scanner.nextInt();
                    low.add(a);
                    high.add(b);
                }
            }
        }

        // Sort the lists
        Collections.sort(low);
        Collections.sort(high);

        if (n % 2 != 0) {
            // n is odd
            // Index calculation: (n + 1) // 2 - 1
            int index = (n + 1) / 2 - 1;
            // Result: high[index] - low[index] + 1
            int result = high.get(index) - low.get(index) + 1;
            System.out.println(result);
        } else {
            // n is even
            // Indices: (n // 2) - 1 and (n // 2)
            int idx1 = n / 2 - 1;
            int idx2 = n / 2;

            // hh = ( high[idx1] + high[idx2] ) / 2
            double hh = (high.get(idx1) + high.get(idx2)) / 2.0;
            
            // ll = ( low[idx1] + low[idx2] ) / 2
            double ll = (low.get(idx1) + low.get(idx2)) / 2.0;
            
            // print ( int ( ( hh - ll ) * 2 ) + 1 )
            // Since the Python code uses integer division implicitly for the intermediate steps 
            // and then casts the final result, we should ensure we handle the calculation correctly.
            // (hh - ll) * 2 + 1
            
            // Since the result of the Python calculation is an integer, we cast the final result.
            // (hh - ll) * 2 + 1
            long result = (long)((hh - ll) * 2) + 1;
            System.out.println(result);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        resolve();
    }
}
