import java.util.Scanner;
import java.util.ArrayList;
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
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                l.add(scanner.nextInt());
            }
        }

        // Calculation logic
        int ans = n - 1;
        int last = 0;

        for (int i : l) {
            ans += Math.abs(last - i) + 1;
            last = i;
        }

        System.out.println(ans);
        scanner.close();
    }
}