import java.util.Scanner;
import java.lang.Math;

public class codeforces_203_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] xxs = line.split(" ");

        if (xxs.length < 6) {
            return;
        }

        // Parse the integers
        int x = Integer.parseInt(xxs[0]);
        int t = Integer.parseInt(xxs[1]);
        int a = Integer.parseInt(xxs[2]);
        int b = Integer.parseInt(xxs[3]);
        int da = Integer.parseInt(xxs[4]);
        int db = Integer.parseInt(xxs[5]);

        if (x == 0) {
            System.out.println("YES");
            return;
        }

        // a_time = min([ a // da , t - 1 ])
        int a_time = Math.min(a / da, t - 1);
        
        // b_time = min([ b // db , t - 1 ])
        int b_time = Math.min(b / db, t - 1);

        for (int i = 0; i <= a_time; i++) {
            for (int j = 0; j <= b_time; j++) {
                int val_a = a - da * i;
                int val_b = b - db * j;

                // Check condition 1: a - da * i == x or b - db * j == x
                if (val_a == x || val_b == x) {
                    System.out.println("YES");
                    return;
                }

                // Check condition 2: (a - da * i) + (b - db * j) == x
                if (val_a + val_b == x) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        // If no solution is found
        System.out.println("NO");
    }
}
