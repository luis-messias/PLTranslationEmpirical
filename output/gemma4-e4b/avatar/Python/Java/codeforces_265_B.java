import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class codeforces_265_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the list l
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                l.add(scanner.nextInt());
            }
        }

        // Calculation
        // Use long for ans to prevent potential integer overflow
        long ans = n - 1;
        int last = 0;

        for (int i : l) {
            // Calculate abs(last - i)
            int diff = Math.abs(last - i);
            
            // ans += abs(last - i) + 1
            ans += (diff + 1);
            
            // last = i
            last = i;
        }

        System.out.println(ans);
        
        scanner.close();
    }
}