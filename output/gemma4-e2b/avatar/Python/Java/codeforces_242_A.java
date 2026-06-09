import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_242_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read x, y, a, b from a single line of input
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            List<int[]> games = new ArrayList<>();

            // Outer loop: i from a to x (inclusive)
            for (int i = a; i <= x; i++) {
                // if (i <= b) continue
                if (i <= b) {
                    continue;
                } else {
                    // Inner loop: j from b to y (inclusive)
                    for (int j = b; j <= y; j++) {
                        // if (i > j)
                        if (i > j) {
                            games.add(new int[]{i, j});
                        }
                    }
                }
            }

            // Print the length of games
            System.out.println(games.size());

            // Print the games
            for (int[] game : games) {
                System.out.println(game[0] + " " + game[1]);
            }
        }
        
        scanner.close();
    }
}