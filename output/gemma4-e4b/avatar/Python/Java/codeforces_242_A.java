import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_242_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read x, y, a, b from input
        if (!scanner.hasNextInt()) {
            // Handle case where input might be missing or malformed
            return;
        }
        
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        List<int[]> games = new ArrayList<>();
        
        // Outer loop for i: range [a, x]
        for (int i = a; i <= x; i++) {
            // Condition: if (i <= b) continue
            if (i <= b) {
                continue;
            }
            
            // Inner loop for j: range [b, y]
            for (int j = b; j <= y; j++) {
                // Condition: if i > j
                if (i > j) {
                    // Store the pair (i, j)
                    games.add(new int[]{i, j});
                }
            }
        }
        
        // Print the length of games
        System.out.println(games.size());
        
        // Print each pair
        for (int[] pair : games) {
            System.out.println(pair[0] + " " + pair[1]);
        }
        
        scanner.close();
    }
}