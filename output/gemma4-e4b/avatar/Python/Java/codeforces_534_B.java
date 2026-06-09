import java.util.Scanner;

public class codeforces_534_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read v1 and v2 (assuming they are on the first line)
        if (!scanner.hasNextInt()) return;
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();

        // Read t and d (assuming they are on the second line)
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        int d = scanner.nextInt();

        // Initialization
        int a = 1;
        int v = v1;
        long distance = 0;

        // Loop
        for (int i = 0; i < t; i++) {
            // Condition: v - v2 > ( t - i - 1 ) * d
            if (v - v2 > (t - i - 1) * d) {
                a *= -1;
                v = (t - i - 1) * d + v2;
            }
            
            // distance += v
            distance += v;
            
            // v += a * d
            v += a * d;
        }

        System.out.println(distance);
        scanner.close();
    }
}