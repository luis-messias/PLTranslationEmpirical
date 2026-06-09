import java.util.Scanner;

public class codeforces_342_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n, m, s, f
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int f = scanner.nextInt();

        // Determine initial direction (d, c)
        int d;
        char c;
        if (s < f) {
            d = 1;
            c = 'R';
        } else {
            d = -1;
            c = 'L';
        }

        // Read initial t, l, r
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        // Simulation variables
        StringBuilder res = new StringBuilder();
        int i = 1; // Time/Step counter
        int j = s; // Current position
        int k = 1; // Obstacle update counter

        // Loop while current position j is not the final position f
        while (j != f) {
            // Check for obstacle update
            if (i > t && k < m) {
                // Read new t, l, r
                if (!scanner.hasNextInt()) break;
                t = scanner.nextInt();
                l = scanner.nextInt();
                r = scanner.nextInt();
                k++;
            }

            // Check for collision: i == t AND (l <= j <= r OR l <= j + d <= r)
            boolean collision = (i == t) && 
                                ( (l <= j && j <= r) || (l <= j + d && j + d <= r) );

            if (collision) {
                res.append('X');
            } else {
                res.append(c);
                j += d; // Move position
            }
            
            i++; // Increment time
        }

        System.out.println(res.toString());
        scanner.close();
    }
}
