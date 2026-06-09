import java.util.Scanner;

public class codeforces_608_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and s from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int c = 0;

        // Loop n times to read f and t
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) break;
            int f = scanner.nextInt();
            int t = scanner.nextInt();

            // x = t - (s - f)
            int x = t - (s - f);

            // if x > c: c = x
            if (x > c) {
                c = x;
            }
        }

        // print s + c
        System.out.println(s + c);
        
        scanner.close();
    }
}