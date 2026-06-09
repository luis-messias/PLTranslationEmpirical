import java.util.Scanner;

public class codeforces_92_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and m from standard input
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        if (!scanner.hasNextInt()) {
            return;
        }
        int m = scanner.nextInt();
        
        scanner.close();

        int i = 1;
        while (m >= i) {
            m -= i;
            // i = ( i % n ) + 1
            i = (i % n) + 1;
        }
        System.out.println(m);
    }
}