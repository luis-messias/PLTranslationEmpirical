import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class s878873709 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            // Handle case where input might be missing or invalid, though typically not needed in CP context
            System.out.println(0);
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        scanner.close();

        // Define the set s = {1, 2, 4, 8, 16, 32, 64}
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(4);
        s.add(8);
        s.add(16);
        s.add(32);
        s.add(64);

        int ans = 0;

        // Iterate from 1 to N
        for (int i = 1; i <= N; i++) {
            if (s.contains(i)) {
                // Since we iterate upwards, ans will store the largest power of 2 found so far.
                ans = i;
            }
        }

        System.out.println(ans);
    }
}