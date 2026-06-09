import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class s878873709 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int N = scanner.nextInt();
        
        // s = {1, 2, 4, 8, 16, 32, 64}
        Set<Integer> s = new HashSet<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64));
        int ans = 0;

        // Iterate from 1 to N and find the largest element in s that is <= N
        for (int i = 1; i <= N; i++) {
            if (s.contains(i)) {
                ans = i;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}