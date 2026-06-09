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
        int i = 1; //