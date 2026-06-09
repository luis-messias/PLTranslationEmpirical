import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_350_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read t (T sequence)
        // t = [0] + list(map(int, input().split()))
        int[] t = new int[n + 1];
        t[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (scanner.hasNextInt()) {
                t[i] = scanner.nextInt();
            }
        }

        // Read a (A sequence)
        // a = [0] + list(map(int, input().split()))
        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
