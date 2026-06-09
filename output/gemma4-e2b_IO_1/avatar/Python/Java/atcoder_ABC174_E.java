import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class atcoder_ABC174_E {

    static boolean check(List<Integer> lis, int k, int mid) {
        int currentK = k;
        for (int i : lis) {
            if (i % mid == 0) {
                currentK += 1;
            }
            currentK -= (i / mid);
        }
        return currentK >= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int k = scanner.nextInt();

        // Read lis from the second line
        List<Integer> lis = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lis.add(scanner.nextInt());
        }

        if (lis.isEmpty()) {
            System.out.println(0);
            return;
        }

        // a, b = 1, max(lis)
        int a = 1;
        int b = Collections.max(lis);
        
        // ans = b
        int ans = b;

        // Binary Search
        while (a <= b) {
            int mid = a + (b - a) / 2; // Safer way to calculate mid
            
            if (check(lis, k, mid)) {
                ans = mid;
                b = mid - 1;
            } else {
                a = mid + 1;
            }
        }

        System.out.println(ans);

        scanner.close();
    }
}
