import java.util.Scanner;

public class codeforces_534_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read v1 and v2 from the first line
        if (!scanner.hasNext()) return;
        int v1 = scanner.nextInt();
        if (!scanner.hasNext()) return;
        int v2 = scanner.nextInt();

        // Read t and d from the second line
        if (!scanner.hasNext()) return;
        int t = scanner.nextInt();
        if (!scanner.hasNext()) return;
        int d = scanner.nextInt();

        // Initialization
        int a = 1;
        int v = v1;
        long distance = 0; // Use long for distance accumulation just in case

        // Loop
        for (int i = 0; i < t; i++) {
            // Check condition: v - v2 > (t - i - 1) * d
            // Note: (t - i - 1) can be negative if t is small, but since i < t, t - i - 1 >= -1.
            // If t=1, i=0: t-i-1 = 0.
            // If t=2, i=0: t-i-1 = 1.
            // If t=2, i=1: t-i-1 = 0.
            
            long rhs = (long) (t - i - 1) * d;
            
            if (v - v2 > rhs) {
                a *= -1;
                // v = (t - i - 1) * d + v2
                v = (int) rhs + v2;
            }
            
            distance += v;
            // v += a * d
            v += a * d;
        }

        System.out.println(distance);
        
        scanner.close();
    }
}