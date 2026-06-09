import java.util.*;
import java.io.*;

public class codeforces_459_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] l1 = new int[n];
        for (int i = 0; i < n; i++) {
            l1[i] = scanner.nextInt();
        }
        Arrays.sort(l1);
        int a = l1[n - 1];
        int b = l1[0];
        if (a == b) {
            System.out.println(a - b + " " + (n) * (n - 1) / 2);
        } else {
            int ac = 0;
            int bc = 0;
            for (int x : l1) {
                if (x == a) ac++;
                if (x == b) bc++;
            }
            System.out.println(a - b + " " + ac * bc);
        }
    }
}
