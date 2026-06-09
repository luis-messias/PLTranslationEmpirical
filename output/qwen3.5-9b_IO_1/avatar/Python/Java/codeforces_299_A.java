import java.util.*;
import java.io.*;

public class codeforces_299_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }
        Arrays.sort(a);
        boolean divisible = false;
        for (int x : a) {
            if (x % a[0] == 0) {
                divisible = true;
                break;
            }
        }
        System.out.println(divisible ? a[0] : -1);
    }
}
