import java.util.Scanner;
import java.lang.Math;

public class codeforces_242_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // I = lambda : [ * map ( int , sys.stdin.readline ( ).split ( ) ) ]
        // IS = lambda : input ( )
        // IN = lambda : int ( input ( ) )
        // IF = lambda : float ( input ( ) )

        // Read n = IN()
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read l, r = map(int, input().split())
        if (!scanner.hasNextInt()) return;
        int l = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int r = scanner.nextInt();

        int id = 0;

        // Loop for i in range(1, n)
        for (int i = 1; i < n; i++) {
            // Read li, ri = map(int, input().split())
            if (!scanner.hasNextInt()) break;
            int li = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int ri = scanner.nextInt();

            // if li <= l and r <= ri : id = i
            if (li <= l && r <= ri) {
                id = i;
            }
            // elif li < l or r < ri : id = n
            else if (li < l || r < ri) {
                id = n;
            }

            // l = min(l, li)
            l = Math.min(l, li);
            // r = max(r, ri)
            r = Math.max(r, ri);
        }

        // print (-1 if id == n else id + 1)
        if (id == n) {
            System.out.println("-1");
        } else {
            System.out.println(id + 1);
        }

        scanner.close();
    }
}